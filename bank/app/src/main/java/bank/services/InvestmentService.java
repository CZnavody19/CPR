package bank.services;

import com.google.inject.Inject;

import bank.account.BankAccount;
import bank.account.InvestmentAccount;
import bank.investment.UserInvestment;

public class InvestmentService {
    @Inject
    private DatabaseService databaseService;

    @Inject
    private MoneyTransferService moneyTransferService;

    public void calculateinvestments() {
        for (BankAccount _account : databaseService.accounts) {
            if (!(_account instanceof InvestmentAccount)) {
                continue;
            }
            InvestmentAccount account = (InvestmentAccount) _account;
            if (account.getInvestments() == null) {
                continue;
            }

            double totalGeneratedMoney = 0.0;
            for (UserInvestment investment : account.getInvestments()) {
                totalGeneratedMoney += investment.getGeneratedMoney();
            }

            for (UserInvestment investment : account.getInvestments()) {
                investment.setAmount(investment.getAmount()
                        + (totalGeneratedMoney * investment.getUserDividerPrct() / investment.getValue()));
            }

            moneyTransferService.deposit(account, totalGeneratedMoney);
        }
    }
}
package bank.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import bank.account.BankAccount;
import bank.account.SavingsAccount;

@Singleton
public class InterestingService {
    @Inject
    private DatabaseService databaseService;

    @Inject
    private FeeCalculator feeCalculator;

    @Inject
    private MoneyTransferService moneyTransferService;

    public void calculate() {
        for (BankAccount account : this.databaseService.accounts) {
            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                double interestAmount = this.feeCalculator.calculateInterest(savingsAccount.getBalance());
                this.moneyTransferService.deposit(account, interestAmount);
            }
        }
    }
}
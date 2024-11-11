package bank.account;

import java.util.ArrayList;
import java.util.List;

import bank.investment.UserInvestment;
import bank.person.Owner;

public class InvestmentAccount extends BankAccount {
    private List<UserInvestment> investments;

    public InvestmentAccount(String accountNumber, Owner owner) {
        super(accountNumber, owner);
        investments = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "InvestmentAccount{" +
                "accountNumber='" + this.accountNumber + '\'' +
                ", balance=" + this.balance +
                ", owner=" + this.owner +
                ", cards=" + this.cards +
                ", investments=" + this.investments +
                '}';
    }

    public List<UserInvestment> getInvestments() {
        return this.investments;
    }

    public void addInvestment(UserInvestment investment) {
        this.investments.add(investment);
    }
}

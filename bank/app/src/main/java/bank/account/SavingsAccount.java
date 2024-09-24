package bank.account;

import bank.person.Owner;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, Owner owner, double interestRate) {
        super(accountNumber, owner);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }
}

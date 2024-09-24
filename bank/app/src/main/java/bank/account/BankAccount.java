package bank.account;

import bank.person.Owner;

public class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected Owner owner;

    public BankAccount(String accountNumber, Owner owner) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + this.accountNumber + '\'' +
                ", balance=" + this.balance +
                ", owner=" + this.owner +
                '}';
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Owner getOwner() {
        return this.owner;
    }
}

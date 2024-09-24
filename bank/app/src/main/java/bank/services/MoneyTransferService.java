package bank.services;

import bank.account.BankAccount;

public class MoneyTransferService {
    private FeeCalculator feeCalculator;

    private void changeBalance(BankAccount account, double amount) {
        if (amount == 0) {
            return;
        }
        account.setBalance(account.getBalance() + amount);
    }

    public MoneyTransferService(FeeCalculator feeCalculator) {
        this.feeCalculator = feeCalculator;
    }

    public void deposit(BankAccount account, double amount) throws IllegalArgumentException {
        if (Double.isNaN(amount) || Double.isInfinite(amount) || amount < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        changeBalance(account, amount);
    }

    public void withdraw(BankAccount account, double amount) throws IllegalArgumentException {
        withdraw(account, amount, true);
    }

    public void withdraw(BankAccount account, double amount, boolean applyFee) throws IllegalArgumentException {
        if (Double.isNaN(amount) || Double.isInfinite(amount) || amount < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        double fee = 0d;

        if (applyFee) {
            fee = this.feeCalculator.withdrawFee(amount);
        }

        if (account.getBalance() < amount + fee) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        changeBalance(account, -(amount + fee));
    }

    public void transfer(BankAccount from, BankAccount to, double amount) throws IllegalArgumentException {
        withdraw(from, amount, false);
        deposit(to, amount);

        changeBalance(from, -this.feeCalculator.transferFee(amount));
    }
}

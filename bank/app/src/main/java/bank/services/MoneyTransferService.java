package bank.services;

import bank.account.BankAccount;

public class MoneyTransferService {
    private static void changeBalance(BankAccount account, double amount) {
        if (amount == 0) {
            return;
        }
        account.setBalance(account.getBalance() + amount);
    }

    public static void deposit(BankAccount account, double amount) throws IllegalArgumentException {
        if (Double.isNaN(amount) || Double.isInfinite(amount) || amount < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        changeBalance(account, amount);
    }

    public static void withdraw(BankAccount account, double amount) throws IllegalArgumentException {
        if (Double.isNaN(amount) || Double.isInfinite(amount) || amount < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        changeBalance(account, -FeeCalculator.withdrawFee(amount));

        changeBalance(account, -amount);
    }

    public static void transfer(BankAccount from, BankAccount to, double amount) throws IllegalArgumentException {
        withdraw(from, amount);
        deposit(to, amount);

        changeBalance(from, -FeeCalculator.transferFee(amount));
    }
}

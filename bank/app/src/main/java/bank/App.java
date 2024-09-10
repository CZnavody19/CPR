package bank;

import bank.account.BankAccount;
import bank.person.Owner;
import bank.services.MoneyTransferService;

public class App {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", new Owner("John", "Doe"));

        MoneyTransferService.deposit(account, 1000);
        MoneyTransferService.deposit(account, 1000);
        MoneyTransferService.deposit(account, 1000);
        MoneyTransferService.deposit(account, 1000);
        MoneyTransferService.deposit(account, 1000);

        MoneyTransferService.withdraw(account, 750);

        System.out.println(account);
    }
}

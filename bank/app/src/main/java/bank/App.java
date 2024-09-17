package bank;

import bank.account.BankAccount;
import bank.services.MoneyTransferService;
import bank.factories.OwnerFactory;
import bank.factories.BankAccountFactory;

public class App {
    public static void main(String[] args) {
        BankAccount account = BankAccountFactory.createBankAccount(OwnerFactory.createOwner("John", "Doe"));

        MoneyTransferService.deposit(account, 1000);
        MoneyTransferService.deposit(account, 1000);
        MoneyTransferService.deposit(account, 1000);
        MoneyTransferService.deposit(account, 1000);
        MoneyTransferService.deposit(account, 1000);

        MoneyTransferService.withdraw(account, 750);

        System.out.println(account);
    }
}

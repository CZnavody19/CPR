package bank;

import bank.account.BankAccount;
import bank.services.FeeCalculator;
import bank.services.MoneyTransferService;
import bank.services.NumberGenerator;
import bank.factories.OwnerFactory;
import bank.person.Owner;
import bank.factories.BankAccountFactory;

public class App {
    private static BankAccountFactory bankAccountFactory;
    private static OwnerFactory ownerFactory;

    private static FeeCalculator feeCalculator;
    private static MoneyTransferService moneyTransferService;
    private static NumberGenerator numberGenerator;

    private static void initServices() {
        numberGenerator = new NumberGenerator();
        bankAccountFactory = new BankAccountFactory(numberGenerator);
        ownerFactory = new OwnerFactory();
        feeCalculator = new FeeCalculator();
        moneyTransferService = new MoneyTransferService(feeCalculator);
    }

    public static void main(String[] args) {
        initServices();

        Owner person1 = ownerFactory.createOwner("John", "Doe");
        Owner person2 = ownerFactory.createOwner("Jane", "Doe");

        BankAccount account1 = bankAccountFactory.createStudentBankAccount(person1);
        BankAccount account2 = bankAccountFactory.createBankAccount(person2, "69");

        moneyTransferService.deposit(account1, 1000);
        moneyTransferService.deposit(account2, 1000);

        System.out.println(account1);
        System.out.println(account2);
    }
}

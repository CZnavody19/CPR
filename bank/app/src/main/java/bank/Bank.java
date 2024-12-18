package bank;

import java.io.IOException;

import com.google.inject.Inject;

import bank.account.BankAccount;
import bank.account.InvestmentAccount;
import bank.card.Card;
import bank.facades.BankAccountFacade;
import bank.facades.CardFacade;
import bank.factories.OwnerFactory;
import bank.person.Owner;
import bank.services.AtmService;
import bank.services.DatabaseService;
import bank.services.InvestmentService;
import bank.services.JsonSerializationService;
import bank.services.MoneyTransferService;

public class Bank {
    @Inject
    private OwnerFactory ownerFactory;

    @Inject
    private MoneyTransferService moneyTransferService;
    @Inject
    private JsonSerializationService serializationService;
    @Inject
    private InvestmentService investmentService;

    @Inject
    private AtmService atmService;

    @Inject
    private CardFacade cardFacade;

    @Inject
    private BankAccountFacade bankAccountFacade;

    @Inject
    private DatabaseService db;

    public void run() {
        if (!serializationService.fileExits()) {
            createSmth();
        }

        try {
            serializationService.deserialize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (BankAccount account : db.accounts) {
            System.out.println(account);
        }
        System.out.println("----");
        for (Card card : db.cards) {
            System.out.println(card);
        }
        System.out.println("----");
        for (Owner owner : db.owners) {
            System.out.println(owner);
        }
    }

    private void createSmth() {
        Owner person1 = ownerFactory.createOwner("John", "Doe");
        Owner person2 = ownerFactory.createOwner("Jane", "Doe");

        BankAccount account1 = bankAccountFacade.createBankAccount(person1, "69");
        BankAccount account2 = bankAccountFacade.createBankAccount(person2, "69");

        moneyTransferService.deposit(account1, 1000);
        moneyTransferService.deposit(account2, 1000);

        System.out.println(serializationService.serializeOwner(person1));

        System.out.println(account1);
        System.out.println(account2);

        Card card1 = cardFacade.createCard(account1);

        System.out.println(account1);

        atmService.withdrawAmount(card1, card1.getPin(), 100);

        System.out.println(account1);

        InvestmentAccount investmentAccount = bankAccountFacade.createInvestmentAccount(person1, "420");

        System.out.println(investmentAccount);

        moneyTransferService.deposit(investmentAccount, 1000);

        System.out.println(investmentAccount);

        bankAccountFacade.addInvestment(investmentAccount, "Investment 1", 100, 0.1, 0.5);
        bankAccountFacade.addInvestment(investmentAccount, "Investment 2", 100, 0.1, 0.5);

        System.out.println(investmentAccount);

        investmentService.calculateinvestments();

        System.out.println(investmentAccount);

        try {
            serializationService.serialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

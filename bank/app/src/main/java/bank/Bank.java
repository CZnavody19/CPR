package bank;

import com.google.inject.Inject;

import bank.account.BankAccount;
import bank.card.Card;
import bank.factories.BankAccountFactory;
import bank.factories.CardFactory;
import bank.factories.OwnerFactory;
import bank.person.Owner;
import bank.services.AtmService;
import bank.services.JsonSerializationService;
import bank.services.MoneyTransferService;

public class Bank {
    @Inject
    private BankAccountFactory bankAccountFactory;
    @Inject
    private OwnerFactory ownerFactory;
    @Inject
    private CardFactory cardFactory;

    @Inject
    private MoneyTransferService moneyTransferService;
    @Inject
    private JsonSerializationService serializationService;

    @Inject
    private AtmService atmService;

    public void run() {
        Owner person1 = ownerFactory.createOwner("John", "Doe");
        Owner person2 = ownerFactory.createOwner("Jane", "Doe");

        BankAccount account1 = bankAccountFactory.createStudentBankAccount(person1);
        BankAccount account2 = bankAccountFactory.createBankAccount(person2, "69");

        moneyTransferService.deposit(account1, 1000);
        moneyTransferService.deposit(account2, 1000);

        System.out.println(serializationService.serializeOwner(person1));

        System.out.println(account1);
        System.out.println(account2);

        Card card1 = cardFactory.createCard();
        account1.addCard(card1);

        System.out.println(account1);

        atmService.withdrawAmount(card1, card1.getPin(), 100);

        System.out.println(account1);
    }
}

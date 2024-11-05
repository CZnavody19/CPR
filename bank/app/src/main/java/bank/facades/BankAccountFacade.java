package bank.facades;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import bank.account.BankAccount;
import bank.card.Card;
import bank.factories.BankAccountFactory;
import bank.factories.CardFactory;
import bank.person.Owner;

@Singleton
public class BankAccountFacade {
    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private CardFactory cardFactory;

    public BankAccount createBankAccount(Owner owner, String pin) {
        BankAccount account = bankAccountFactory.createBankAccount(owner, pin);
        Card card = cardFactory.createCard();
        account.addCard(card);
        return account;
    }
}

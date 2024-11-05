package bank.facades;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import bank.account.BankAccount;
import bank.card.Card;
import bank.factories.CardFactory;

@Singleton
public class CardFacade {
    @Inject
    private CardFactory cardFactory;

    public Card createCard(BankAccount account) {
        Card card = cardFactory.createCard();
        account.addCard(card);
        return card;
    }
}

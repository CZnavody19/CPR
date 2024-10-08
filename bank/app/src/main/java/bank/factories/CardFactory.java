package bank.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import bank.card.Card;
import bank.services.DatabaseService;
import bank.services.NumberGenerator;

@Singleton
public class CardFactory {
    @Inject
    private NumberGenerator numberGenerator;

    @Inject
    private DatabaseService databaseService;

    public Card createCard() {
        Card ca = new Card(numberGenerator.generateCardNumber(), numberGenerator.generatePin());
        databaseService.cards.add(ca);
        return ca;
    }
}

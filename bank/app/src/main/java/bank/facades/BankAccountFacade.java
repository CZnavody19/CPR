package bank.facades;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import bank.account.BankAccount;
import bank.account.InvestmentAccount;
import bank.card.Card;
import bank.factories.BankAccountFactory;
import bank.factories.CardFactory;
import bank.factories.UserInvestmentFactory;
import bank.person.Owner;

@Singleton
public class BankAccountFacade {
    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private CardFactory cardFactory;

    @Inject
    private UserInvestmentFactory userInvestmentFactory;

    public BankAccount createBankAccount(Owner owner, String pin) {
        BankAccount account = bankAccountFactory.createBankAccount(owner, pin);
        Card card = cardFactory.createCard();
        account.addCard(card);
        return account;
    }

    public InvestmentAccount createInvestmentAccount(Owner owner, String accountNumber) {
        return bankAccountFactory.createInvestmentBankAccount(accountNumber, owner);
    }

    public void addInvestment(InvestmentAccount account, String name, double amount, double value, double dividerPrct) {
        account.addInvestment(userInvestmentFactory.createUserInvestment(name, amount, value, dividerPrct));
    }
}

package bank.account;

import java.util.HashMap;
import java.util.Map;

import bank.card.Card;
import bank.person.Owner;

public class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected Owner owner;
    protected Map<String, Card> cards;

    public BankAccount(String accountNumber, Owner owner) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.owner = owner;
        this.cards = new HashMap<String, Card>();
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + this.accountNumber + '\'' +
                ", balance=" + this.balance +
                ", owner=" + this.owner +
                ", cards=" + this.cards +
                '}';
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public Map<String, Card> getAllCards() {
        return this.cards;
    }

    public Card getCard(String cardNumber) {
        return this.cards.get(cardNumber);
    }

    public void addCard(Card card) {
        this.cards.put(card.getCardNumber(), card);
    }
}

package bank.services;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Singleton;

import bank.account.BankAccount;
import bank.card.Card;
import bank.person.Owner;

@Singleton
public class DatabaseService {
    public List<BankAccount> accounts = new ArrayList<BankAccount>();
    public List<Card> cards = new ArrayList<Card>();
    public List<Owner> owners = new ArrayList<Owner>();
}

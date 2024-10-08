package bank.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import bank.account.BankAccount;
import bank.card.Card;

@Singleton
public class AtmService {
    @Inject
    private DatabaseService databaseService;

    @Inject
    MoneyTransferService moneyTransferService;

    public void withdrawAmount(Card card, String pin, double amount) {
        BankAccount selectedAccount = null;
        for (BankAccount account : databaseService.accounts) {
            if (account.getAllCards().containsKey(card.getCardNumber())) {
                selectedAccount = account;
            }
        }

        if (selectedAccount == null) {
            System.out.println("No account found");
            return;
        }

        if (!card.verifyPin(pin)) {
            System.out.println("Invalid pin");
            return;
        }

        moneyTransferService.withdraw(selectedAccount, amount);

        System.out.println("Withdrawn " + amount + " from account " + selectedAccount.getAccountNumber());

        System.out.println("New balance: " + selectedAccount.getBalance());

        System.out.println("Thank you for using our ATM");
    }
}

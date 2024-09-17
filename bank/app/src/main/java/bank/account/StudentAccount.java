package bank.account;

import bank.person.Owner;

public class StudentAccount extends BankAccount {
    private boolean verified;

    public StudentAccount(String accountNumber, Owner owner) {
        super(accountNumber, owner);
        this.verified = false;
    }
}

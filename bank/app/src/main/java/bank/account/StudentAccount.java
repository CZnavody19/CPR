package bank.account;

import bank.person.Owner;

public class StudentAccount extends BankAccount {
    private boolean verified;

    public StudentAccount(String accountNumber, Owner owner) {
        super(accountNumber, owner);
        this.verified = false;
    }

    @Override
    public String toString() {
        return "StudentAccount{" +
                "accountNumber='" + this.accountNumber + '\'' +
                ", balance=" + this.balance +
                ", owner=" + this.owner +
                ", verified=" + this.verified +
                '}';
    }

    public void verify() {
        this.verified = true;
    }

    public boolean isVerified() {
        return this.verified;
    }
}

package bank.factories;

import bank.account.BankAccount;
import bank.account.StudentAccount;
import bank.person.Owner;
import bank.services.NumberGenerator;

public class BankAccountFactory {
    NumberGenerator numberGenerator;

    public BankAccountFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public BankAccount createBankAccount(Owner owner) {
        return new BankAccount(this.numberGenerator.generateAccountNumber(), owner);
    }

    public BankAccount createBankAccount(Owner owner, String accountNumber) {
        return new BankAccount(accountNumber, owner);
    }

    public StudentAccount createStudentBankAccount(Owner owner) {
        return new StudentAccount(this.numberGenerator.generateAccountNumber(), owner);
    }

    public StudentAccount createStudentBankAccount(Owner owner, String accountNumber) {
        return new StudentAccount(accountNumber, owner);
    }
}

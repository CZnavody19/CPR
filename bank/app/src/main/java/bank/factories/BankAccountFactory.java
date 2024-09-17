package bank.factories;

import bank.account.BankAccount;
import bank.account.StudentAccount;
import bank.person.Owner;
import bank.services.NumberGenerator;

public class BankAccountFactory {
    public static BankAccount createBankAccount(Owner owner) {
        return new BankAccount(NumberGenerator.generateAccountNumber(), owner);
    }

    public static BankAccount createBankAccount(String accountNumber, Owner owner) {
        return new BankAccount(accountNumber, owner);
    }

    public static StudentAccount createStudentBankAccount(Owner owner) {
        return new StudentAccount(NumberGenerator.generateAccountNumber(), owner);
    }

    public static StudentAccount createStudentBankAccount(String accountNumber, Owner owner) {
        return new StudentAccount(accountNumber, owner);
    }

}

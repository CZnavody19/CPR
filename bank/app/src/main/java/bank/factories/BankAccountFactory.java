package bank.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import bank.account.BankAccount;
import bank.account.StudentAccount;
import bank.interfaces.INumberGenerator;
import bank.person.Owner;
import bank.services.DatabaseService;

@Singleton
public class BankAccountFactory {
    @Inject
    INumberGenerator numberGenerator;

    @Inject
    DatabaseService databaseService;

    public BankAccount createBankAccount(Owner owner) {
        return createBankAccount(owner, this.numberGenerator.generateAccountNumber());
    }

    public BankAccount createBankAccount(Owner owner, String accountNumber) {
        BankAccount ba = new BankAccount(accountNumber, owner);
        databaseService.accounts.add(ba);
        return ba;
    }

    public StudentAccount createStudentBankAccount(Owner owner) {
        return createStudentBankAccount(owner, this.numberGenerator.generateAccountNumber());
    }

    public StudentAccount createStudentBankAccount(Owner owner, String accountNumber) {
        StudentAccount sa = new StudentAccount(accountNumber, owner);
        databaseService.accounts.add(sa);
        return sa;
    }
}

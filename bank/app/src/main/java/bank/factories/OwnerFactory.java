package bank.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import bank.interfaces.INumberGenerator;
import bank.person.Owner;
import bank.services.DatabaseService;

@Singleton
public class OwnerFactory {
    @Inject
    private INumberGenerator numberGenerator;

    @Inject
    private DatabaseService databaseService;

    public Owner createOwner(String firstName, String lastName) {
        System.out.println("Your account number can be: " + this.numberGenerator.generateAccountNumber());
        Owner ow = new Owner(firstName, lastName);
        databaseService.owners.add(ow);
        return ow;
    }
}

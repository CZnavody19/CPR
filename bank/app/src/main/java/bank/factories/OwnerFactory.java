package bank.factories;

import bank.interfaces.INumberGenerator;
import bank.person.Owner;

public class OwnerFactory {
    private INumberGenerator numberGenerator;

    public OwnerFactory(INumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Owner createOwner(String firstName, String lastName) {
        System.out.println("Your account number can be: " + this.numberGenerator.generateAccountNumber());
        return new Owner(firstName, lastName);
    }
}

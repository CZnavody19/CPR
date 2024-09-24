package bank.factories;

import bank.person.Owner;

public class OwnerFactory {
    public Owner createOwner(String firstName, String lastName) {
        return new Owner(firstName, lastName);
    }
}

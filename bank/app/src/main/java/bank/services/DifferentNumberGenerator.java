package bank.services;

import bank.interfaces.INumberGenerator;

public class DifferentNumberGenerator implements INumberGenerator {
    public String generateAccountNumber() {
        return "123456789";
    }
}

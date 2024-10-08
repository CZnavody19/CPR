package bank.services;

import com.google.inject.Singleton;

import bank.interfaces.INumberGenerator;

@Singleton
public class DifferentNumberGenerator implements INumberGenerator {
    public String generateAccountNumber() {
        return "123456789";
    }
}

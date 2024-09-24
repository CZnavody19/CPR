package bank.services;

import bank.interfaces.INumberGenerator;

public class NumberGenerator implements INumberGenerator {
    public String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            accountNumber.append(random.nextInt(10));
        }
        accountNumber.append("/");
        for (int i = 0; i < 4; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }
}

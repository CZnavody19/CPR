package bank.services;

import java.util.Random;

public class NumberGenerator {
    static Random random = new Random();

    public static String generateAccountNumber() {
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

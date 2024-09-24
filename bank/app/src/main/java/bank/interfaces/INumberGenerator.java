package bank.interfaces;

import java.util.Random;

public interface INumberGenerator {
    public static final Random random = new Random();

    String generateAccountNumber();
}

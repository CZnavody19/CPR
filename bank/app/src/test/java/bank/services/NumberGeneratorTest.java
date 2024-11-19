package bank.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    private NumberGenerator numberGenerator;

    @BeforeEach
    public void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    public void testGenerateAccountNumber() {
        String accountNumber = numberGenerator.generateAccountNumber();
        assertEquals(15, accountNumber.length());
        assertEquals('/', accountNumber.charAt(10));
        assertTrue(accountNumber.substring(0, 10).matches("\\d{10}"));
        assertTrue(accountNumber.substring(11).matches("\\d{4}"));
    }

    @Test
    public void testGenerateCardNumber() {
        String cardNumber = numberGenerator.generateCardNumber();
        assertEquals(16, cardNumber.length());
        assertTrue(cardNumber.matches("\\d{16}"));
    }

    @Test
    public void testGeneratePin() {
        String pin = numberGenerator.generatePin();
        assertEquals(4, pin.length());
        assertTrue(pin.matches("\\d{4}"));
    }
}
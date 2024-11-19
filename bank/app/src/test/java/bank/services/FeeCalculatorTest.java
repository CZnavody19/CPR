package bank.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeeCalculatorTest {

    private final FeeCalculator feeCalculator = new FeeCalculator();

    @Test
    public void testWithdrawFee() {
        assertEquals(0, feeCalculator.withdrawFee(500), 0.01);
        assertEquals(5, feeCalculator.withdrawFee(501), 0.01);
    }

    @Test
    public void testTransferFee() {
        assertEquals(0, feeCalculator.transferFee(1000), 0.01);
        assertEquals(10, feeCalculator.transferFee(1001), 0.01);
    }

    @Test
    public void testCalculateInterest() {
        assertEquals(1.5, feeCalculator.calculateInterest(1000), 0.01);
    }
}
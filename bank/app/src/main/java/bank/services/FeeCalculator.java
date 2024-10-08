package bank.services;

import com.google.inject.Singleton;

@Singleton
public class FeeCalculator {
    private static final double WITHDRAW_FEE = 5;
    private static final double TRANSFER_FEE = 10;

    public double withdrawFee(double amount) {
        if (amount > 500) {
            return WITHDRAW_FEE;
        }
        return 0;
    }

    public double transferFee(double amount) {
        if (amount > 1000) {
            return TRANSFER_FEE;
        }
        return 0;
    }
}

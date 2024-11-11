package bank.factories;

import com.google.inject.Singleton;

import bank.investment.UserInvestment;

@Singleton
public class UserInvestmentFactory {
    public UserInvestment createUserInvestment(String name, double amount, double value, double dividerPrct) {
        return new UserInvestment(name, amount, value, dividerPrct);
    }
}

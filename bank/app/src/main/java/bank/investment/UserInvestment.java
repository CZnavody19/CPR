package bank.investment;

public class UserInvestment {
    protected String name;
    protected double amount;
    protected double value;
    protected double userDividerPrct;

    public UserInvestment(String name, double amount, double value, double userDividerPrct) {
        this.name = name;
        this.amount = amount;
        this.value = value;
        this.userDividerPrct = userDividerPrct;
    }

    @Override
    public String toString() {
        return "UserInvestment{" +
                "name='" + this.name + '\'' +
                ", amount=" + this.amount +
                ", value=" + this.value +
                ", userDividerPrct=" + this.userDividerPrct +
                '}';
    }

    public String getName() {
        return this.name;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getValue() {
        return this.value;
    }

    public double getUserDividerPrct() {
        return this.userDividerPrct;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setUserDividerPrct(double userDividerPrct) {
        this.userDividerPrct = userDividerPrct;
    }

    public double getGeneratedMoney() {
        return this.value * this.amount;
    }
}

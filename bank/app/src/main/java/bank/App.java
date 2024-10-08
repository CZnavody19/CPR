package bank;

import com.google.inject.Guice;
import com.google.inject.Injector;

import bank.services.BankInjector;

public class App {
    public static void main(String[] args) {
        try {
            Injector injector = Guice.createInjector(new BankInjector());
            Bank bank = injector.getInstance(Bank.class);
            bank.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

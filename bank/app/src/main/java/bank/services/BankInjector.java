package bank.services;

import com.google.inject.AbstractModule;

import bank.interfaces.INumberGenerator;

public class BankInjector extends AbstractModule {
    @Override
    protected void configure() {
        this.bind(INumberGenerator.class).to(NumberGenerator.class);
    }
}

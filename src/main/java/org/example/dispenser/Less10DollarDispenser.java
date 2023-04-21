package org.example.dispenser;

import org.example.model.Currency;
import org.example.DispenseChain;

public class Less10DollarDispenser implements DispenseChain {
    private DispenseChain dispenseChain;
    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() < 10){
            System.out.println("Dispensing $" + currency.getAmount());
        }
    }
}

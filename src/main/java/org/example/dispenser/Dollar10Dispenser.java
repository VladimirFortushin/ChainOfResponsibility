package org.example.dispenser;

import org.example.model.Currency;
import org.example.DispenseChain;

public class Dollar10Dispenser implements DispenseChain {
    private DispenseChain dispenseChain;
    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 10){
            int bills = currency.getAmount() / 10;
            int remainder = currency.getAmount() % 10;
            System.out.println("Dispensing " + bills + " $10 bills.");
            if(remainder != 0){
                dispenseChain.dispense(new Currency(remainder));
            }
        }else {
            dispenseChain.dispense(currency);
        }
    }
}

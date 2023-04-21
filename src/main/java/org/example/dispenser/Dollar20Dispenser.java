package org.example.dispenser;

import org.example.model.Currency;
import org.example.DispenseChain;

public class Dollar20Dispenser implements DispenseChain {
    private DispenseChain dispenseChain;
    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {

        if(currency.getAmount() >= 20){
            int bills = currency.getAmount() / 20;
            int remainder = currency.getAmount() % 20;
            System.out.println("Dispensing " + bills + " $20 bills.");
            if(remainder != 0){
                dispenseChain.dispense(new Currency(remainder));
            }
        }else{
            dispenseChain.dispense(currency);
        }

    }
}

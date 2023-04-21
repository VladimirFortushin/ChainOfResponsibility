package org.example.dispenser;

import org.example.model.Currency;
import org.example.DispenseChain;

public class Dollar50Dispenser implements DispenseChain {

    private DispenseChain dispenseChain;
    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 50){
            int bills = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;
            System.out.println("Dispensing " + bills + " $50 bills.");
            if(remainder != 0){dispenseChain.dispense(new Currency(remainder));}
        }else{
            dispenseChain.dispense(currency);
        }
    }
}

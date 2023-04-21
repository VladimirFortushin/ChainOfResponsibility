package org.example;

import org.example.model.Currency;

public interface DispenseChain {
    void setNextChain(DispenseChain dispenseChain);
    void dispense(Currency currency);
}

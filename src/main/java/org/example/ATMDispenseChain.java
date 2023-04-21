package org.example;

import org.example.dispenser.Dollar10Dispenser;
import org.example.dispenser.Dollar20Dispenser;
import org.example.dispenser.Dollar50Dispenser;
import org.example.dispenser.Less10DollarDispenser;
import org.example.model.Currency;

import java.util.Scanner;

public class ATMDispenseChain {
    private DispenseChain chain50 = new Dollar50Dispenser();
    private DispenseChain chain20 = new Dollar20Dispenser();
    private DispenseChain chain10 = new Dollar10Dispenser();
    private DispenseChain chain = new Less10DollarDispenser();

    public ATMDispenseChain(){
        chain50.setNextChain(chain20);
        chain20.setNextChain(chain10);
        chain10.setNextChain(chain);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenseChain = new ATMDispenseChain();
        while (true){
            int amount = 0;
            System.out.println("Please enter the amount to dispense");
            Scanner scanner = new Scanner(System.in);
            amount = scanner.nextInt();

            atmDispenseChain.chain50.dispense(new Currency(amount));
        }
    }
}
package LLD.DesignAtmMachine.Aditya.State.ChainOfResponsibility;

import LLD.DesignAtmMachine.Aditya.AtmMachine;

import java.util.Map;

public abstract class WithDrawCash {

    public static int DENOMINATION_2000 = 2000;
    public static int DENOMINATION_500 = 500;
    public static int DENOMINATION_200 = 200;
    public static int DENOMINATION_100 = 100;

    protected WithDrawCash nextHandler;
    protected int denomination;

    public WithDrawCash(int denomination, WithDrawCash nextHandler) {
        this.denomination = denomination;
        this.nextHandler = nextHandler;
    }

    public void setNextHandler(WithDrawCash nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * Try to dispense 'amount' using this handler and the subsequent handlers.
     * Uses and mutates the provided cashMap (a temporary snapshot). Returns remaining amount after attempting.
     */
    public int dispenseCash(Map<Integer,Integer> cashMap, int amount){
        if (denomination <=0 || amount <=0) {
            return amount;
        }

        int quantity = cashMap.getOrDefault(denomination, 0);
        int numOfNotes = Math.min(amount / denomination, quantity);

        amount = amount - (numOfNotes * denomination);
        cashMap.put(denomination, quantity - numOfNotes);

        if(nextHandler != null) {
            return nextHandler.dispenseCash(cashMap, amount);
        } else {
            return amount;
        }
    }

    public abstract void write();
}

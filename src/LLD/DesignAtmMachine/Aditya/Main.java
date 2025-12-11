package LLD.DesignAtmMachine.Aditya;

public class Main {
    public static void main(String[] args) {
        AtmMachine atmMachine = new AtmMachine(100000.0);
        // Always fetch the current state from the machine so we follow
        // state transitions (don't cache the initial state object).
        // Simulate inserting a card
        atmMachine.getState().insertCardToAtm(atmMachine);

        // Simulate entering card number
        atmMachine.getState().insertCard(atmMachine,1234);

        // Simulate selecting operation (2 => withdraw)
        atmMachine.getState().selectOperation(atmMachine,2);

        // Simulate entering amount to withdraw
        atmMachine.getState().EnterMoneyToWithdraw(atmMachine,500);

    }
}

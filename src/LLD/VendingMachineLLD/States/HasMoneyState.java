package LLD.VendingMachineLLD.States;

import LLD.VendingMachineLLD.VendingMachine;
import LLD.VendingMachineLLD.InvalidCoinException;
import LLD.VendingMachineLLD.InvalidStateException;

/**
 * HasMoneyState: User has inserted money
 * Transitions: SelectProduct -> SelectionState, CancelTransaction -> IdleState
 */
public class HasMoneyState extends VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine, int coinValue) throws InvalidCoinException, InvalidStateException {
        try {
            machine.getPayment().insertCoinByValue(coinValue);
            System.out.println("Coin inserted successfully. Total: " + machine.getPayment().getTotalAmount());
        } catch (InvalidCoinException e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) throws InvalidStateException {
        System.out.println("Transitioning to SelectionState. Please select a product.");
        machine.setState(new SelectionState());
    }

    @Override
    public void cancelTransaction(VendingMachine machine) throws InvalidStateException {
        int refundAmount = machine.getPayment().refundAll();
        System.out.println("Transaction cancelled. Refunded amount: " + refundAmount);
        machine.setState(new IdleState());
    }

    @Override
    public String toString() {
        return "HAS_MONEY";
    }
}


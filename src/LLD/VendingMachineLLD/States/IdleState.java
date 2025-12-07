package LLD.VendingMachineLLD.States;

import LLD.VendingMachineLLD.VendingMachine;
import LLD.VendingMachineLLD.InvalidStateException;

/**
 * Idle State: Machine is waiting for user interaction
 * Transitions: InsertCoin -> HasMoneyState
 */
public class IdleState extends VendingMachineState {

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws InvalidStateException {
        System.out.println("Transitioning to HasMoneyState. Please insert coins.");
        machine.setState(new HasMoneyState());
    }

    @Override
    public String toString() {
        return "IDLE";
    }
}


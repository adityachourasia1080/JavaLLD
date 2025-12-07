package LLD.VendingMachineLLD.States;

import LLD.VendingMachineLLD.VendingMachine;
import LLD.VendingMachineLLD.InvalidCoinException;
import LLD.VendingMachineLLD.InsufficientPaymentException;
import LLD.VendingMachineLLD.InvalidStateException;

/**
 * Abstract base class for all vending machine states.
 * Follows State Design Pattern.
 */
public abstract class VendingMachineState {

    /**
     * Handle coin insertion button click
     */
    public void clickOnInsertCoinButton(VendingMachine machine) throws InvalidStateException {
        throw new InvalidStateException("Cannot insert coin in state: " + this.getClass().getSimpleName());
    }

    /**
     * Handle product selection button click
     */
    public void clickOnSelectProductButton(VendingMachine machine) throws InvalidStateException {
        throw new InvalidStateException("Cannot select product in state: " + this.getClass().getSimpleName());
    }

    /**
     * Insert a coin
     */
    public void insertCoin(VendingMachine machine, int coinValue) throws InvalidCoinException, InvalidStateException {
        throw new InvalidStateException("Cannot insert coin in state: " + this.getClass().getSimpleName());
    }

    /**
     * Select a product
     */
    public void selectProduct(VendingMachine machine, int itemCode) throws InvalidStateException {
        throw new InvalidStateException("Cannot select product in state: " + this.getClass().getSimpleName());
    }

    /**
     * Cancel transaction and refund money
     */
    public void cancelTransaction(VendingMachine machine) throws InvalidStateException {
        throw new InvalidStateException("Cannot cancel in state: " + this.getClass().getSimpleName());
    }

    /**
     * Dispense the selected product
     */
    public void dispenseProduct(VendingMachine machine, int itemCode) throws Exception {
        // This is called internally
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}


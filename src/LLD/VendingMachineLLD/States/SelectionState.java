package LLD.VendingMachineLLD.States;

import LLD.VendingMachineLLD.VendingMachine;
import LLD.VendingMachineLLD.Item;
import LLD.VendingMachineLLD.InsufficientPaymentException;
import LLD.VendingMachineLLD.InsufficientInventoryException;
import LLD.VendingMachineLLD.InvalidStateException;

/**
 * SelectionState: User is selecting a product
 * Transitions: SelectProduct -> DispenseState, CancelTransaction -> IdleState
 */
public class SelectionState extends VendingMachineState {

    @Override
    public void selectProduct(VendingMachine machine, int itemCode) throws InvalidStateException {
        try {
            // Check if item exists
            Item item = machine.getInventory().getItem(itemCode);

            // Check if item is available
            if (!machine.getInventory().isItemAvailable(itemCode)) {
                System.out.println("Error: Item out of stock.");
                cancelTransaction(machine);
                return;
            }

            // Check if user has enough money
            if (!machine.getPayment().isSufficientAmount(item.getPrice())) {
                System.out.println(String.format("Error: Insufficient funds. Need: %d, Provided: %d",
                    item.getPrice(), machine.getPayment().getTotalAmount()));
                cancelTransaction(machine);
                return;
            }

            // All checks passed - move to dispense
            System.out.println("Selection successful. Proceeding to dispense.");
            machine.setSelectedItemCode(itemCode);
            machine.setState(new DispenseState());

        } catch (InsufficientInventoryException e) {
            System.out.println("Error: " + e.getMessage());
            try {
                cancelTransaction(machine);
            } catch (InvalidStateException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void cancelTransaction(VendingMachine machine) throws InvalidStateException {
        int refundAmount = machine.getPayment().refundAll();
        System.out.println("Transaction cancelled. Refunded amount: " + refundAmount);
        machine.setState(new IdleState());
    }

    @Override
    public String toString() {
        return "SELECTION";
    }
}


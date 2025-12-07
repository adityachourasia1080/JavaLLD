package LLD.VendingMachineLLD.States;

import LLD.VendingMachineLLD.VendingMachine;
import LLD.VendingMachineLLD.Item;
import LLD.VendingMachineLLD.InvalidStateException;
import LLD.VendingMachineLLD.InsufficientInventoryException;
import LLD.VendingMachineLLD.InsufficientPaymentException;

/**
 * DispenseState: Dispensing the selected product
 * Transitions: DispenseProduct -> IdleState
 */
public class DispenseState extends VendingMachineState {

    @Override
    public void dispenseProduct(VendingMachine machine, int itemCode) throws InvalidStateException {
        try {
            // Get the item
            Item item = machine.getInventory().dispenseItem(itemCode);
            System.out.println("Dispensing: " + item);

            // Calculate and return change
            int change = machine.getPayment().calculateChange(item.getPrice());
            if (change > 0) {
                System.out.println("Returning change: " + change);
            }

            // Reset payment and return to idle
            machine.getPayment().reset();
            machine.setState(new IdleState());
            System.out.println("Transaction complete. Machine returned to IDLE state.");

        } catch (InsufficientInventoryException e) {
            System.out.println("Error dispensing: " + e.getMessage());
            try {
                int refund = machine.getPayment().refundAll();
                System.out.println("Refunded amount: " + refund);
                machine.setState(new IdleState());
            } catch (InvalidStateException ex) {
                ex.printStackTrace();
            }
        } catch (InsufficientPaymentException e) {
            System.out.println("Error: " + e.getMessage());
            try {
                int refund = machine.getPayment().refundAll();
                System.out.println("Refunded amount: " + refund);
                machine.setState(new IdleState());
            } catch (InvalidStateException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "DISPENSE";
    }
}


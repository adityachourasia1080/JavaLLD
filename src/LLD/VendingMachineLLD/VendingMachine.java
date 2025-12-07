package LLD.VendingMachineLLD;

import LLD.VendingMachineLLD.States.VendingMachineState;
import LLD.VendingMachineLLD.States.IdleState;

/**
 * Main VendingMachine class - Orchestrator
 * Delegates to Inventory, Payment, and State classes
 * Follows Single Responsibility Principle
 */
public class VendingMachine {
    private VendingMachineState currentState;
    private final Inventory inventory;
    private final Payment payment;
    private int selectedItemCode;

    public VendingMachine() {
        this.currentState = new IdleState();
        this.inventory = new Inventory();
        this.payment = new Payment();
        this.selectedItemCode = -1;
        initializeInventory();
    }

    /**
     * Initialize default inventory
     */
    private void initializeInventory() {
        try {
            inventory.addItem(new Item(100, "Coke", 25), 5);
            inventory.addItem(new Item(101, "Pepsi", 30), 5);
            inventory.addItem(new Item(102, "Sprite", 25), 3);
            inventory.addItem(new Item(103, "Fanta", 35), 4);
            System.out.println("Inventory initialized successfully.");
        } catch (Exception e) {
            System.out.println("Error initializing inventory: " + e.getMessage());
        }
    }

    // === State Management ===

    public void setState(VendingMachineState state) {
        if (state == null) {
            throw new IllegalArgumentException("State cannot be null");
        }
        System.out.println("State transition: " + currentState + " -> " + state);
        this.currentState = state;
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    // === User Interactions ===

    /**
     * User clicks "Insert Coin" button
     */
    public void clickInsertCoinButton() throws Exception {
        currentState.clickOnInsertCoinButton(this);
    }

    /**
     * User inserts a coin
     */
    public void insertCoin(int coinValue) throws Exception {
        currentState.insertCoin(this, coinValue);
    }

    /**
     * User clicks "Select Product" button
     */
    public void clickSelectProductButton() throws Exception {
        currentState.clickOnSelectProductButton(this);
    }

    /**
     * User selects a product
     */
    public void selectProduct(int itemCode) throws Exception {
        currentState.selectProduct(this, itemCode);
        // If we're in DispenseState, proceed to dispense
        if (currentState.getClass().getSimpleName().equals("DispenseState")) {
            dispenseProduct(itemCode);
        }
    }

    /**
     * Cancel transaction
     */
    public void cancelTransaction() throws Exception {
        currentState.cancelTransaction(this);
    }

    /**
     * Dispense the product (internal call)
     */
    private void dispenseProduct(int itemCode) throws Exception {
        currentState.dispenseProduct(this, itemCode);
    }

    // === Getters for State Classes ===

    public Inventory getInventory() {
        return inventory;
    }

    public Payment getPayment() {
        return payment;
    }

    public int getSelectedItemCode() {
        return selectedItemCode;
    }

    public void setSelectedItemCode(int itemCode) {
        this.selectedItemCode = itemCode;
    }

    // === Display ===

    public void displayInventory() {
        System.out.println("\n" + inventory);
    }

    public void displayMachineStatus() {
        System.out.println("\n=== Vending Machine Status ===");
        System.out.println("Current State: " + currentState);
        System.out.println("Payment: " + payment);
        System.out.println("================================\n");
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "currentState=" + currentState +
                ", payment=" + payment +
                '}';
    }
}


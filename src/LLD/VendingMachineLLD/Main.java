package LLD.VendingMachineLLD;

/**
 * Demonstration of the Vending Machine LLD
 * Shows different scenarios and usage patterns
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   VENDING MACHINE LLD DEMONSTRATION");
        System.out.println("========================================\n");

        // Scenario 1: Successful purchase
        System.out.println("\n--- SCENARIO 1: Successful Purchase ---");
        scenario1_SuccessfulPurchase();

        // Scenario 2: Insufficient funds
        System.out.println("\n--- SCENARIO 2: Insufficient Funds ---");
        scenario2_InsufficientFunds();

        // Scenario 3: Item out of stock
        System.out.println("\n--- SCENARIO 3: Item Out of Stock ---");
        scenario3_OutOfStock();

        // Scenario 4: Cancel transaction
        System.out.println("\n--- SCENARIO 4: Cancel Transaction ---");
        scenario4_CancelTransaction();

        // Scenario 5: Invalid coin
        System.out.println("\n--- SCENARIO 5: Invalid Coin ---");
        scenario5_InvalidCoin();

        // Scenario 6: Multiple coins to reach amount
        System.out.println("\n--- SCENARIO 6: Multiple Coins ---");
        scenario6_MultipleCoinInsertions();

        System.out.println("\n========================================");
        System.out.println("   DEMONSTRATION COMPLETE");
        System.out.println("========================================");
    }

    /**
     * Scenario 1: User inserts exact amount and successfully purchases an item
     */
    private static void scenario1_SuccessfulPurchase() {
        try {
            VendingMachine machine = new VendingMachine();
            machine.displayInventory();

            System.out.println("\n1. User clicks Insert Coin button");
            machine.clickInsertCoinButton();

            System.out.println("\n2. User inserts 25 rupees (one 25 coin)");
            machine.insertCoin(25);

            System.out.println("\n3. User clicks Select Product button");
            machine.clickSelectProductButton();

            System.out.println("\n4. User selects item code 100 (Coke - costs 25)");
            machine.selectProduct(100);

            machine.displayMachineStatus();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Scenario 2: User inserts insufficient funds
     */
    private static void scenario2_InsufficientFunds() {
        try {
            VendingMachine machine = new VendingMachine();

            System.out.println("\n1. User clicks Insert Coin button");
            machine.clickInsertCoinButton();

            System.out.println("\n2. User inserts only 20 rupees");
            machine.insertCoin(20);

            System.out.println("\n3. User clicks Select Product button");
            machine.clickSelectProductButton();

            System.out.println("\n4. User tries to select item code 101 (Pepsi - costs 30)");
            machine.selectProduct(101);

            System.out.println("\n5. Machine detects insufficient funds and refunds");
            machine.displayMachineStatus();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Scenario 3: Item out of stock
     */
    private static void scenario3_OutOfStock() {
        try {
            VendingMachine machine = new VendingMachine();

            System.out.println("\n1. User clicks Insert Coin button");
            machine.clickInsertCoinButton();

            System.out.println("\n2. User inserts 40 rupees");
            machine.insertCoin(40);

            System.out.println("\n3. User clicks Select Product button");
            machine.clickSelectProductButton();

            System.out.println("\n4. User tries to select item code 999 (non-existent)");
            machine.selectProduct(999);

            machine.displayMachineStatus();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Scenario 4: User cancels transaction
     */
    private static void scenario4_CancelTransaction() {
        try {
            VendingMachine machine = new VendingMachine();

            System.out.println("\n1. User clicks Insert Coin button");
            machine.clickInsertCoinButton();

            System.out.println("\n2. User inserts 50 rupees");
            machine.insertCoin(50);

            System.out.println("\n3. User changes mind and cancels transaction");
            machine.cancelTransaction();

            System.out.println("\n4. Machine refunds all money and returns to IDLE");
            machine.displayMachineStatus();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Scenario 5: User tries to insert invalid coin denomination
     */
    private static void scenario5_InvalidCoin() {
        try {
            VendingMachine machine = new VendingMachine();

            System.out.println("\n1. User clicks Insert Coin button");
            machine.clickInsertCoinButton();

            System.out.println("\n2. User tries to insert invalid coin (35 rupees)");
            machine.insertCoin(35);

        } catch (Exception e) {
            System.out.println("Error caught: " + e.getMessage());
        }
    }

    /**
     * Scenario 6: User inserts multiple coins to reach desired amount
     */
    private static void scenario6_MultipleCoinInsertions() {
        try {
            VendingMachine machine = new VendingMachine();

            System.out.println("\n1. User clicks Insert Coin button");
            machine.clickInsertCoinButton();

            System.out.println("\n2. User inserts 20 rupees");
            machine.insertCoin(20);

            System.out.println("\n3. User inserts another 10 rupees");
            machine.insertCoin(10);

            System.out.println("\n4. Total inserted: 30 rupees. User clicks Select Product");
            machine.clickSelectProductButton();

            System.out.println("\n5. User selects item code 101 (Pepsi - costs 30)");
            machine.selectProduct(101);

            System.out.println("\n6. Transaction successful");
            machine.displayMachineStatus();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


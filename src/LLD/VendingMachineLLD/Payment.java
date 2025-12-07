package LLD.VendingMachineLLD;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages payment processing for the vending machine.
 * Handles coin insertion, change calculation, and refunds.
 * Separate class following Single Responsibility Principle.
 */
public class Payment {
    private int totalAmount;
    private final List<Coin> coinsInserted;

    public Payment() {
        this.totalAmount = 0;
        this.coinsInserted = new ArrayList<>();
    }

    /**
     * Insert a coin into the machine
     */
    public void insertCoin(Coin coin) {
        if (coin == null) {
            throw new IllegalArgumentException("Coin cannot be null");
        }
        coinsInserted.add(coin);
        totalAmount += coin.getValue();
    }

    /**
     * Insert coin by value (validates denomination)
     */
    public void insertCoinByValue(int value) throws InvalidCoinException {
        if (!Coin.isValidCoin(value)) {
            throw new InvalidCoinException("Invalid coin denomination: " + value + ". Valid denominations: 1, 5, 10, 20, 50, 100");
        }
        insertCoin(Coin.getCoinByValue(value));
    }

    /**
     * Get total amount inserted
     */
    public int getTotalAmount() {
        return totalAmount;
    }

    /**
     * Calculate change
     */
    public int calculateChange(int itemPrice) throws InsufficientPaymentException {
        if (totalAmount < itemPrice) {
            throw new InsufficientPaymentException(
                String.format("Insufficient payment. Need: %d, Provided: %d", itemPrice, totalAmount)
            );
        }
        return totalAmount - itemPrice;
    }

    /**
     * Refund all money
     */
    public int refundAll() {
        int refundAmount = totalAmount;
        totalAmount = 0;
        coinsInserted.clear();
        return refundAmount;
    }

    /**
     * Reset payment (used after successful transaction)
     */
    public void reset() {
        totalAmount = 0;
        coinsInserted.clear();
    }

    /**
     * Check if sufficient amount for item
     */
    public boolean isSufficientAmount(int itemPrice) {
        return totalAmount >= itemPrice;
    }

    @Override
    public String toString() {
        return String.format("Payment(Total Amount: %d, Coins Inserted: %d)", totalAmount, coinsInserted.size());
    }
}


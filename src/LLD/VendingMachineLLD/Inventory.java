package LLD.VendingMachineLLD;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the inventory of items in the vending machine.
 * Separate class following Single Responsibility Principle.
 */
public class Inventory {
    private final Map<Integer, Item> itemsByCode;
    private final Map<Integer, Integer> itemQuantity;

    public Inventory() {
        this.itemsByCode = new HashMap<>();
        this.itemQuantity = new HashMap<>();
    }

    /**
     * Add an item to inventory
     */
    public void addItem(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (itemsByCode.containsKey(item.getCode())) {
            itemQuantity.put(item.getCode(), itemQuantity.get(item.getCode()) + quantity);
        } else {
            itemsByCode.put(item.getCode(), item);
            itemQuantity.put(item.getCode(), quantity);
        }
    }

    /**
     * Get item by code
     */
    public Item getItem(int code) throws InsufficientInventoryException {
        if (!itemsByCode.containsKey(code)) {
            throw new InsufficientInventoryException("Item with code " + code + " not found");
        }
        return itemsByCode.get(code);
    }

    /**
     * Check if item is available
     */
    public boolean isItemAvailable(int code) {
        return itemsByCode.containsKey(code) && itemQuantity.get(code) > 0;
    }

    /**
     * Get quantity of an item
     */
    public int getQuantity(int code) throws InsufficientInventoryException {
        if (!itemsByCode.containsKey(code)) {
            throw new InsufficientInventoryException("Item with code " + code + " not found");
        }
        return itemQuantity.get(code);
    }

    /**
     * Dispense an item (decrease quantity)
     */
    public Item dispenseItem(int code) throws InsufficientInventoryException {
        if (!isItemAvailable(code)) {
            throw new InsufficientInventoryException("Item with code " + code + " is out of stock");
        }
        Item item = itemsByCode.get(code);
        itemQuantity.put(code, itemQuantity.get(code) - 1);
        return item;
    }

    /**
     * Get all items (for display purposes)
     */
    public Map<Integer, Item> getAllItems() {
        return new HashMap<>(itemsByCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Inventory:\n");
        for (int code : itemsByCode.keySet()) {
            sb.append(String.format("  %s - Quantity: %d\n", itemsByCode.get(code), itemQuantity.get(code)));
        }
        return sb.toString();
    }
}


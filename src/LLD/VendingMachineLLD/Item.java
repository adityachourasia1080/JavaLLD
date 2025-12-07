package LLD.VendingMachineLLD;

/**
 * Represents an item available in the vending machine.
 * Each item has a unique code, name, and price.
 */
public class Item {
    private final int code;
    private final String name;
    private final int price;

    public Item(int code, String name, int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Item(Code=%d, Name=%s, Price=%d)", code, name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return code == item.code;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(code);
    }
}


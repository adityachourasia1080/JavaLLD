package LLD.VendingMachineLLD;

public enum Coin {
    ONE(1), FIVE(5), TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isValidCoin(int value) {
        for (Coin coin : values()) {
            if (coin.value == value) return true;
        }
        return false;
    }

    public static Coin getCoinByValue(int value) {
        for (Coin coin : values()) {
            if (coin.value == value) return coin;
        }
        throw new IllegalArgumentException("Invalid coin: " + value);
    }

    @Override
    public String toString() {
        return "Coin(" + value + ")";
    }
}


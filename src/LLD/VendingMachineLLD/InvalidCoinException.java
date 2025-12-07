package LLD.VendingMachineLLD;

public class InvalidCoinException extends Exception {
    public InvalidCoinException(String message) {
        super(message);
    }
    public InvalidCoinException(String message, Throwable cause) {
        super(message, cause);
    }
}


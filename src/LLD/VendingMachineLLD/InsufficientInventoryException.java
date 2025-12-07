package LLD.VendingMachineLLD;

public class InsufficientInventoryException extends Exception {
    public InsufficientInventoryException(String message) {
        super(message);
    }
    public InsufficientInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
}


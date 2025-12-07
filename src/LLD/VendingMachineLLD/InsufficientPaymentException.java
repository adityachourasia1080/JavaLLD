package LLD.VendingMachineLLD;

public class InsufficientPaymentException extends Exception {
    public InsufficientPaymentException(String message) {
        super(message);
    }
    public InsufficientPaymentException(String message, Throwable cause) {
        super(message, cause);
    }
}


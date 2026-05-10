package LLD.ParkingLotLLD.paymentMethod;

public class CreditCardPaymentMethod implements PaymentMethod {

    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CreditCardPaymentMethod(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean recordPayment(double amount, String details) {
        // Here you would integrate with a payment gateway to process the credit card payment.
        // For simplicity, we will just print the payment details and return true to indicate success.
        System.out.println("Processing credit card payment:");
        System.out.println("Amount: " + amount);
        System.out.println("Details: " + details);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Card Holder Name: " + cardHolderName);
        System.out.println("Expiry Date: " + expiryDate);
        // In a real implementation, you would not print sensitive information like CVV.
        return true; // Assume payment is successful
    }
}

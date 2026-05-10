package LLD.ParkingLotLLD.paymentMethod;

public class UPIPaymentMethod implements PaymentMethod{
    @Override
    public boolean recordPayment(double amount, String details) {
        System.out.println("Payment of " + amount + " recorded using UPI with details: " + details);
        return true; // Assuming payment is always successful for this example
    }
}

package LLD.ParkingLotLLD.paymentMethod;

public interface PaymentMethod {

    public boolean recordPayment(double amount, String details);
}

package LLD.ParkingLotLLD.paymentStrategy;

public class FixedPaymentStrategy implements PaymentStrategy{
    @Override
    public double calculatePayment(int hours) {
        return (hours)/24 * 100; // Assuming a fixed rate of 100 per day
    }
}

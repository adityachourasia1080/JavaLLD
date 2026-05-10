package LLD.ParkingLotLLD.paymentStrategy;

public class HourlyPaymentStrategy implements PaymentStrategy {

    @Override
        public double calculatePayment(int hours) {
            if(hours <= 2) {
                return hours * 10;
            } else if(hours <= 5) {
                return 20 + (hours - 2) * 8;
            } else {
                return 44 + (hours - 5) * 5;
            }
        }
}

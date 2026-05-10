package LLD.ParkingLotLLD.exitGate;

import LLD.ParkingLotLLD.Ticket;
import LLD.ParkingLotLLD.parkingBuilding.ParkingBuilding;
import LLD.ParkingLotLLD.paymentMethod.PaymentMethod;
import LLD.ParkingLotLLD.paymentMethod.UPIPaymentMethod;
import LLD.ParkingLotLLD.paymentStrategy.FixedPaymentStrategy;
import LLD.ParkingLotLLD.paymentStrategy.PaymentStrategy;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExitGate {

    public ParkingBuilding parkingBuilding;
    public PaymentStrategy paymentStrategy;
    public PaymentMethod paymentMethod;

    public ExitGate(ParkingBuilding parkingBuilding) {
        this.parkingBuilding = parkingBuilding;
        paymentStrategy= new FixedPaymentStrategy();
        paymentMethod= new UPIPaymentMethod();
    }

    public void processExit(Ticket ticket) {

        double amount = paymentStrategy.calculatePayment(5);

        boolean paymentSuccessful=paymentMethod.recordPayment(amount, "Payment for ticket: " + ticket.getTicketId());

        if (paymentSuccessful) {
            System.out.println("Payment successful. You may exit.");
            parkingBuilding.unParkVehicle(ticket);
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }
}

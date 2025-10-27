package LLD.ParkingLotLLD.PaymentsHandler;

import LLD.ParkingLotLLD.Cost.CostFactory;
import LLD.ParkingLotLLD.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class Payment {

    public long pay(Ticket t, CostFactory cf) {
        Duration duration = Duration.between(t.startTime, LocalDateTime.now());
        System.out.println("Seconds: " + duration.getSeconds());
        int basicCost= cf.getCostDetails(t.vehicle.type);

        long minutes = duration.toMinutes();
        long hoursCeil = (long) Math.ceil(minutes / 60.0);
        return basicCost*hoursCeil;
    }
}

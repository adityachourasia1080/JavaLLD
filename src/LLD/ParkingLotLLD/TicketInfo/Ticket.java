package LLD.ParkingLotLLD.TicketInfo;

import LLD.ParkingLotLLD.ParkingInfo.Spot.ParkingSpot;
import LLD.ParkingLotLLD.VehicleInfo.Vehicle;

import java.time.LocalDateTime;

public class Ticket {

    public LocalDateTime startTime;
    public Vehicle vehicle;
    public ParkingSpot ps;



    public Ticket(Vehicle v, ParkingSpot ps){
        this.vehicle= v;
        this.ps=ps;
        this.startTime=LocalDateTime.now();
    }

}

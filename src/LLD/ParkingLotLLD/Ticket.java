package LLD.ParkingLotLLD;

import LLD.ParkingLotLLD.ParkingManagerHandler.ParkingSpotManager;

import java.time.LocalDateTime;

public class Ticket {

    public Vehicle vehicle;
    public LocalDateTime startTime;

     public Ticket(Vehicle vehicle){
         this.startTime=LocalDateTime.now();
         this.vehicle= vehicle;
     }

     public String PrintTicket(){
         String str= new String(String.valueOf(startTime));
         return vehicle+" "+ str;
     }

}

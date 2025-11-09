package LLD.ParkingLotLLD;

import LLD.ParkingLotLLD.ParkingInfo.Manager.ParkingSpotManager;
import LLD.ParkingLotLLD.TicketInfo.Ticket;

public class ExitGate {
     public ParkingSpotManager psm;

     public ExitGate(ParkingSpotManager psm){
         this.psm=psm;
     }


    public void makePayment(Ticket t){
        //make payment
        //succesfull then add ps back to list
        System.out.println("Succesfully recorded payment for vehicle : "+ t.vehicle.vehicleNo);

        psm.addParkingSpot(t.ps);

    }



}

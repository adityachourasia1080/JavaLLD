package LLD.ParkingLotLLD;

import LLD.ParkingLotLLD.ParkingInfo.Manager.ParkingSpotManager;
import LLD.ParkingLotLLD.ParkingInfo.Spot.ParkingSpot;
import LLD.ParkingLotLLD.TicketInfo.Ticket;
import LLD.ParkingLotLLD.VehicleInfo.Vehicle;

public class EntranceGate {

    public ParkingSpotManager psm;

    public EntranceGate(ParkingSpotManager PSM){
        psm=PSM;
    }

    public Ticket createTicket(Vehicle v){

        System.out.println("Started Ticket creation for : "+ v.vehicleNo);
        ParkingSpot ps= psm.assignParkingSpot(v);
        Ticket t= new Ticket(v,ps);
        System.out.println("Ticket created for : "+ v.vehicleNo);
        return t;
    }
}

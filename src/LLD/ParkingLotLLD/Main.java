package LLD.ParkingLotLLD;

import LLD.ParkingLotLLD.ParkingInfo.Manager.ParkingSpotManager;
import LLD.ParkingLotLLD.ParkingInfo.Spot.Four_WheelerPS;
import LLD.ParkingLotLLD.ParkingInfo.Spot.ParkingSpot;
import LLD.ParkingLotLLD.ParkingInfo.Spot.Two_WheelerPS;
import LLD.ParkingLotLLD.TicketInfo.Ticket;
import LLD.ParkingLotLLD.VehicleInfo.Vehicle;
import LLD.ParkingLotLLD.VehicleInfo.VehicleType;

public class Main {

    public  static void main(String[]args){

        ParkingSpot ps1= new Four_WheelerPS();
        ParkingSpot ps2= new Two_WheelerPS();
        ParkingSpot ps3= new Four_WheelerPS();
        ParkingSpot ps4= new Two_WheelerPS();

        ParkingSpotManager psm= new ParkingSpotManager();

        //psm.addParkingSpot(ps1);
        psm.addParkingSpot(ps2);
        //psm.addParkingSpot(ps3);
        psm.addParkingSpot(ps4);

        Vehicle v1= new Vehicle("MH31-1234", VehicleType.TWO_WHEELER);
        Vehicle v2= new Vehicle("KA-31-5678",VehicleType.FOUR_WHEELER);

        EntranceGate eg= new EntranceGate(psm);

        Ticket t1= eg.createTicket(v1);
        Ticket t2=eg.createTicket(v2);

        ExitGate egg= new ExitGate(psm);
        egg.makePayment(t1);

    }
}

package LLD.ParkingLotLLD.entryGate;

import LLD.ParkingLotLLD.Ticket;
import LLD.ParkingLotLLD.parkingBuilding.ParkingBuilding;
import LLD.ParkingLotLLD.vehicleType;

public class EntryGate {
    public ParkingBuilding parkingBuilding;

    public EntryGate(ParkingBuilding parkingBuilding) {
        this.parkingBuilding = parkingBuilding;
    }

    public Ticket generateTicket(vehicleType vt) {
        return parkingBuilding.assignParkingSpot(vt);
    }

    public boolean checkAvailability(vehicleType vt) {
        return parkingBuilding.checkParkingSpotAvailability(vt);
    }
}

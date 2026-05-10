package LLD.ParkingLotLLD.spotManagers;

import LLD.ParkingLotLLD.ParkingSpot;

public interface PsManager {

    ParkingSpot parkVehicle();
    void unparkVehicle(ParkingSpot PS);
    boolean isParkingSpotFree();


}

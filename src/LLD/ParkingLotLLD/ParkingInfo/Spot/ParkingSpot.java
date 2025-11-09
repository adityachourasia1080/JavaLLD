package LLD.ParkingLotLLD.ParkingInfo.Spot;

import LLD.ParkingLotLLD.VehicleInfo.VehicleType;

public interface ParkingSpot {

    VehicleType getType();
    double cost();
    String id();
}

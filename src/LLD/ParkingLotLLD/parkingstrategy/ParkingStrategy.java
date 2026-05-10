package LLD.ParkingLotLLD.parkingstrategy;

import LLD.ParkingLotLLD.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {

    ParkingSpot findParkingSpot(List<ParkingSpot> lis);

}

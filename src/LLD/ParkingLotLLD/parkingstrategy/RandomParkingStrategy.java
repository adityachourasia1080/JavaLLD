package LLD.ParkingLotLLD.parkingstrategy;

import LLD.ParkingLotLLD.ParkingSpot;

import java.util.List;

public class RandomParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> lis) {

        for(ParkingSpot spot : lis) {
            if(spot.isFree()) {
                return spot;
            }
        }
        return null;
    }
}

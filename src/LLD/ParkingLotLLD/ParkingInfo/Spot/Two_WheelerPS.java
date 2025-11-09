package LLD.ParkingLotLLD.ParkingInfo.Spot;

import LLD.ParkingLotLLD.VehicleInfo.VehicleType;

import java.util.UUID;

public class Two_WheelerPS implements ParkingSpot{
    String id;

    public Two_WheelerPS(){
        this.id= UUID.randomUUID().toString();
    }
    @Override
    public VehicleType getType() {
        return VehicleType.TWO_WHEELER;
    }

    @Override
    public double cost() {
        return 20;
    }

    @Override
    public String id() {
        return this.id;
    }
}

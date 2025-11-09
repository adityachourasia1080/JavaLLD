package LLD.ParkingLotLLD.ParkingInfo.Spot;

import LLD.ParkingLotLLD.VehicleInfo.VehicleType;

public class Four_WheelerPS implements ParkingSpot{

    String id;

    @Override
    public VehicleType getType() {
        return VehicleType.FOUR_WHEELER;
    }

    @Override
    public double cost() {
        return 40;
    }

    @Override
    public String id() {
        return this.id;
    }
}

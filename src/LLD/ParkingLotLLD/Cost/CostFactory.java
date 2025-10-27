package LLD.ParkingLotLLD.Cost;

import LLD.ParkingLotLLD.ParkingManagerHandler.VehicleType;

public class CostFactory {

    public BasicFare twoWheeler;
    public BasicFare fourWheeler;

    public CostFactory(){
        twoWheeler = new twoWheelerCost();
        fourWheeler= new fourWheelerCost();
    }

    public int getCostDetails(VehicleType v){
        return switch (v){
            case VehicleType.TWO_WHEELER -> twoWheeler.cost();
            case VehicleType.FOUR_WHEELER -> fourWheeler.cost();
            default -> throw new IllegalArgumentException("Invalid vehicle type: " + v);
        };
    }

}

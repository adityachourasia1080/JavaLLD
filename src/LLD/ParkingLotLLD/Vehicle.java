package LLD.ParkingLotLLD;

import LLD.ParkingLotLLD.ParkingManagerHandler.VehicleType;

public class Vehicle {

    public String VehicleNo;
    public VehicleType type;

    public Vehicle(String vehicleNo,VehicleType type){
        this.VehicleNo= vehicleNo;
        this.type=type;
    }

}

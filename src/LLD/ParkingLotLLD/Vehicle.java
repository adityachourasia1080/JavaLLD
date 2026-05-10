package LLD.ParkingLotLLD;

import lombok.Data;

@Data
public class Vehicle {

    public vehicleType type;
    public String vehicleNumber;

     public Vehicle(vehicleType type, String vehicleNumber) {
        this.type = type;
        this.vehicleNumber = vehicleNumber;
    }
}

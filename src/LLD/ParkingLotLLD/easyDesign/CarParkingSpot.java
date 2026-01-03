package LLD.ParkingLotLLD.easyDesign;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int id) {
        super(id);
    }
    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Car;
    }
}
package LLD.ParkingLotLLD.easyDesign;

public class TruckParkingSpot extends ParkingSpot {
    public TruckParkingSpot(int id) {
        super(id);
    }
    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Truck;
    }
}

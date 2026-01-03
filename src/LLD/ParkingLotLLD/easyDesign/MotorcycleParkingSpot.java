package LLD.ParkingLotLLD.easyDesign;

public class MotorcycleParkingSpot extends ParkingSpot {
    public MotorcycleParkingSpot(int id) {
        super(id);
    }
    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Motorcycle;
    }
}

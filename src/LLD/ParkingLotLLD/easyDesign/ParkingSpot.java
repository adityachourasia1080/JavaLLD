package LLD.ParkingLotLLD.easyDesign;

public abstract class ParkingSpot {
    protected int id;
    protected boolean isAvailable;
    public ParkingSpot(int id) {
        this.id = id;
        this.isAvailable = true;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public abstract boolean canFitVehicle(Vehicle vehicle);
    public void parkVehicle(Vehicle vehicle) {
        isAvailable = false;
        System.out.println("Vehicle parked in spot: " + id);
    }
    public void freeSpot() {
        isAvailable = true;
        System.out.println("Spot " + id + " is now free");
    }
}

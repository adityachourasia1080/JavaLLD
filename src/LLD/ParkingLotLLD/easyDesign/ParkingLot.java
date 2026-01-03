package LLD.ParkingLotLLD.easyDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingSpot> spots;
    private Map<Vehicle, ParkingSpot> parkedVehicles;
    private int capacity;
    private ParkingLot(int capacity) {
        this.capacity = capacity;
        this.spots = new ArrayList<>();
        this.parkedVehicles = new HashMap<>();
    }
    // Singleton instance
    public static synchronized ParkingLot getInstance(int capacity) {
        if (instance == null) {
            instance = new ParkingLot(capacity);
        }
        return instance;
    }
    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.canFitVehicle(vehicle)) {
                spot.parkVehicle(vehicle);
                parkedVehicles.put(vehicle, spot);
                return true;
            }
        }
        System.out.println("No available spot for vehicle: " + vehicle.getLicensePlate());
        return false;
    }
    public void leaveVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkedVehicles.get(vehicle);
        if (spot != null) {
            spot.freeSpot();
            parkedVehicles.remove(vehicle);
        }
    }
    public int getAvailableSpots() {
        int availableSpots = 0;
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                availableSpots++;
            }
        }
        return availableSpots;
    }
    public void addParkingSpot(ParkingSpot spot) {
        if (spots.size() < capacity) {
            spots.add(spot);
        } else {
            System.out.println("Parking lot is full");
        }
    }
}
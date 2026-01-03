package LLD.ParkingLotLLD.easyDesign;

public class ParkingSpotFactory {
    public static ParkingSpot createSpot(String type, int id) {
        switch (type.toLowerCase()) {
            case "car":
                return new CarParkingSpot(id);
            case "motorcycle":
                return new MotorcycleParkingSpot(id);
            case "truck":
                return new TruckParkingSpot(id);
            default:
                throw new IllegalArgumentException("Unknown parking spot type");
        }
    }
}
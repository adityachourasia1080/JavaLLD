package LLD.ParkingLotLLD.easyDesign;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance(5);
        // Create parking spots
        parkingLot.addParkingSpot(ParkingSpotFactory.createSpot("car", 1));
        parkingLot.addParkingSpot(ParkingSpotFactory.createSpot("motorcycle", 2));
        parkingLot.addParkingSpot(ParkingSpotFactory.createSpot("truck", 3));
        // Create vehicles
        Vehicle car = new Car("CAR-1234");
        Vehicle motorcycle = new Motorcycle("MOTO-5678");
        Vehicle truck = new Truck("TRUCK-9101");
        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(motorcycle);
        parkingLot.parkVehicle(truck);
        // Leave parking
        parkingLot.leaveVehicle(car);
    }
}

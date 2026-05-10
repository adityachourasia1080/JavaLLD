package LLD.ParkingLotLLD;

import LLD.ParkingLotLLD.entryGate.EntryGate;
import LLD.ParkingLotLLD.exitGate.ExitGate;
import LLD.ParkingLotLLD.parkingBuilding.ParkingBuilding;
import LLD.ParkingLotLLD.parkingLevel.ParkingLevels;
import LLD.ParkingLotLLD.parkingstrategy.ParkingStrategy;
import LLD.ParkingLotLLD.parkingstrategy.RandomParkingStrategy;
import LLD.ParkingLotLLD.spotManagers.FourWheelerSpotManager;
import LLD.ParkingLotLLD.spotManagers.PsManager;
import LLD.ParkingLotLLD.spotManagers.TwoWheelerSpotManager;

public class Main {

    public static void main(String[] args) {
        // Initialize Parking Building
        ParkingBuilding parkingBuilding = new ParkingBuilding();
        
        // Create Entry and Exit Gates
        EntryGate entryGate = new EntryGate(parkingBuilding);
        ExitGate exitGate = new ExitGate(parkingBuilding);

        // Create Parking Strategy
        ParkingStrategy parkingStrategy = new RandomParkingStrategy();

        // ===== LEVEL 1 SETUP =====
        ParkingLevels level1 = new ParkingLevels(1);
        
        // Create parking spots for two-wheelers
        ParkingSpot ps1 = new ParkingSpot("L1-2W-1", true);
        ParkingSpot ps2 = new ParkingSpot("L1-2W-2", true);
        ParkingSpot ps3 = new ParkingSpot("L1-2W-3", true);

        // Create manager with strategy and add spots
        TwoWheelerSpotManager twoWheelerManager = new TwoWheelerSpotManager(parkingStrategy);
        twoWheelerManager.addParkingSpot(ps1);
        twoWheelerManager.addParkingSpot(ps2);
        twoWheelerManager.addParkingSpot(ps3);
        
        // Create parking spots for four-wheelers
        ParkingSpot ps4 = new ParkingSpot("L1-4W-1", true);
        ParkingSpot ps5 = new ParkingSpot("L1-4W-2", true);
        
        java.util.ArrayList<ParkingSpot> fourWheelerSpots = new java.util.ArrayList<>();
        fourWheelerSpots.add(ps4);
        fourWheelerSpots.add(ps5);

        PsManager fourWheelerManager = new FourWheelerSpotManager(fourWheelerSpots, parkingStrategy);

        // Add managers to parking level
        level1.getParkingSpots().put(vehicleType.TWO_WHEELER, twoWheelerManager);
        level1.getParkingSpots().put(vehicleType.FOUR_WHEELER, fourWheelerManager);

        // Add level to building
        parkingBuilding.pl.add(level1);

        // ===== SIMULATION =====
        System.out.println("===== PARKING LOT SIMULATION =====\n");

        // Vehicle 1: Two-wheeler entry
        Vehicle vehicle1 = new Vehicle(vehicleType.TWO_WHEELER, "AP-04-AB-1234");
        System.out.println("Vehicle 1 entering: " + vehicle1.getVehicleNumber() + " (" + vehicle1.getType() + ")");
        
        if (entryGate.checkAvailability(vehicle1.getType())) {
            Ticket ticket1 = entryGate.generateTicket(vehicle1.getType());
            if (ticket1 != null) {
                System.out.println("✓ Ticket generated - Level: " + ticket1.getLevelNumber() + 
                                 ", Spot: " + ticket1.getPs().getSpotId() + "\n");
            }
        } else {
            System.out.println("✗ No parking spots available\n");
        }

        // Vehicle 2: Four-wheeler entry
        Vehicle vehicle2 = new Vehicle(vehicleType.FOUR_WHEELER, "KA-01-XY-5678");
        System.out.println("Vehicle 2 entering: " + vehicle2.getVehicleNumber() + " (" + vehicle2.getType() + ")");
        
        if (entryGate.checkAvailability(vehicle2.getType())) {
            Ticket ticket2 = entryGate.generateTicket(vehicle2.getType());
            if (ticket2 != null) {
                System.out.println("✓ Ticket generated - Level: " + ticket2.getLevelNumber() + 
                                 ", Spot: " + ticket2.getPs().getSpotId() + "\n");
            }
        } else {
            System.out.println("✗ No parking spots available\n");
        }

        // Vehicle 3: Another two-wheeler
        Vehicle vehicle3 = new Vehicle(vehicleType.TWO_WHEELER, "MH-14-CD-9999");
        System.out.println("Vehicle 3 entering: " + vehicle3.getVehicleNumber() + " (" + vehicle3.getType() + ")");
        
        Ticket ticket3 = null;
        if (entryGate.checkAvailability(vehicle3.getType())) {
            ticket3 = entryGate.generateTicket(vehicle3.getType());
            if (ticket3 != null) {
                System.out.println("✓ Ticket generated - Level: " + ticket3.getLevelNumber() + 
                                 ", Spot: " + ticket3.getPs().getSpotId() + "\n");
            }
        } else {
            System.out.println("✗ No parking spots available\n");
        }

        // Vehicle 4: Check availability when full
        Vehicle vehicle4 = new Vehicle(vehicleType.TWO_WHEELER, "DL-01-QW-1111");
        System.out.println("Vehicle 4 trying to enter: " + vehicle4.getVehicleNumber() + " (" + vehicle4.getType() + ")");
        
        if (entryGate.checkAvailability(vehicle4.getType())) {
            Ticket ticket4 = entryGate.generateTicket(vehicle4.getType());
            if (ticket4 != null) {
                System.out.println("✓ Ticket generated - Level: " + ticket4.getLevelNumber() + 
                                 ", Spot: " + ticket4.getPs().getSpotId() + "\n");
            }
        } else {
            System.out.println("✗ No parking spots available for two-wheelers\n");
        }

        // Exit process
        System.out.println("===== EXIT PROCESS =====\n");
        
        if (ticket3 != null) {
            System.out.println("Vehicle 3 exiting - Processing payment...");
            exitGate.processExit(ticket3);
            System.out.println();
        }

        System.out.println("===== SIMULATION COMPLETE =====");
    }
}

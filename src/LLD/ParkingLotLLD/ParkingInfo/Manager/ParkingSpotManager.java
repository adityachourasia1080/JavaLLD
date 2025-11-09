package LLD.ParkingLotLLD.ParkingInfo.Manager;

import LLD.ParkingLotLLD.ParkingInfo.Spot.ParkingSpot;
import LLD.ParkingLotLLD.TicketInfo.Ticket;
import LLD.ParkingLotLLD.VehicleInfo.Vehicle;
import LLD.ParkingLotLLD.VehicleInfo.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingSpotManager {

    public HashMap<VehicleType,List<ParkingSpot>> available;

     public ParkingSpotManager(){
         available = new HashMap<>();
     }

     public void addParkingSpot(ParkingSpot spot){
         VehicleType type = spot.getType();
         List<ParkingSpot> spots = available.getOrDefault(type, new ArrayList<>());
         spots.add(spot);
         available.put(type, spots);
         System.out.println("Adding parking spot  : "+ spot.id());
     }

     public void removeParkingSpot(ParkingSpot spot){
         List<ParkingSpot> spots = available.get(spot.getType());
         for (ParkingSpot spoty: spots){
             if (spoty == spot){
                 spots.remove(spot);
                 break;
             }
         }
         if (spots.size()!=0) available.put(spot.getType(),spots);
         System.out.println("Removed parking spot  : "+ spot.id());

     }

     public ParkingSpot assignParkingSpot(Vehicle v){
         List<ParkingSpot> spots = available.get(v.vehicleType);
         ParkingSpot a= spots.get(spots.size()-1);
         spots.remove(spots.size()-1);
         available.put(v.vehicleType,spots);
         System.out.println("Assign parking spot: " +a.id() + "to Vehicle :" + v.vehicleNo);
         return a;

     }




}

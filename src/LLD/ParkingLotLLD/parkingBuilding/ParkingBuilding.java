package LLD.ParkingLotLLD.parkingBuilding;

import LLD.ParkingLotLLD.ParkingSpot;
import LLD.ParkingLotLLD.Ticket;
import LLD.ParkingLotLLD.parkingLevel.ParkingLevels;
import LLD.ParkingLotLLD.vehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingBuilding {

    public List<ParkingLevels> pl;

     public ParkingBuilding() {
        pl= new ArrayList<>();
    }


    public Ticket assignParkingSpot(vehicleType vt){
         ParkingSpot spot= null;
        for (ParkingLevels parkingLevel: pl){
            spot=parkingLevel.parkVehicle(vt);
            if (spot!=null){
                Ticket t= new Ticket(spot,parkingLevel.getLevelNo(),vt);
                return t;
            }
        }
        return null;
    }

     public void unParkVehicle(Ticket t){
        for (ParkingLevels parkingLevel: pl){
            if (parkingLevel.getLevelNo()==t.getLevelNumber()){
                parkingLevel.unparkVehicle(t.getVt(),t.getPs());
                break;
            }
        }
    }

    public boolean checkParkingSpotAvailability(vehicleType vt){
        for (ParkingLevels parkingLevel: pl){
            if (parkingLevel.checkParkingSpot(vt)){
                return true;
            }
        }
        return false;
    }
}

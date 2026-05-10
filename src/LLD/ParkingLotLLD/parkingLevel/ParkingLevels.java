package LLD.ParkingLotLLD.parkingLevel;

import LLD.ParkingLotLLD.spotManagers.PsManager;
import LLD.ParkingLotLLD.ParkingSpot;
import LLD.ParkingLotLLD.vehicleType;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ParkingLevels {
    public int levelNo;
    public Map<vehicleType, PsManager> parkingSpots;

     public ParkingLevels(int levelNo) {
        this.parkingSpots = new HashMap<>();
        this.levelNo=levelNo;
    }

     public ParkingSpot parkVehicle(vehicleType vt) {
         PsManager psManagers = parkingSpots.get(vt);
            if(psManagers.isParkingSpotFree()) {
                return psManagers.parkVehicle();
            }
            return null;
     }


     public void unparkVehicle(vehicleType vt, ParkingSpot PS) {
         PsManager psManagers = parkingSpots.get(vt);
            psManagers.unparkVehicle(PS);
     }

     public boolean checkParkingSpot(vehicleType vt) {
         PsManager psManagers = parkingSpots.get(vt);
            return psManagers.isParkingSpotFree();
     }

     public boolean isParkingSpotAvialiable(vehicleType vt){
         PsManager psManagers = parkingSpots.get(vt);
         return psManagers.isParkingSpotFree();
     }
}

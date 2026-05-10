package LLD.ParkingLotLLD;

import LLD.ParkingLotLLD.entryGate.EntryGate;
import LLD.ParkingLotLLD.exitGate.ExitGate;
import LLD.ParkingLotLLD.parkingBuilding.ParkingBuilding;
import lombok.Data;

@Data
public class ParkingLot {

    public ParkingBuilding parkingBuilding;
    public EntryGate entryGate;
    public ExitGate exitGate;

    public ParkingLot(ParkingBuilding parkingBuilding, EntryGate entryGate, ExitGate exitGate) {
        this.parkingBuilding = parkingBuilding;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }


}

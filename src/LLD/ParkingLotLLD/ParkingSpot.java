package LLD.ParkingLotLLD;

import lombok.Data;

@Data
public class ParkingSpot {

    public String spotId;
    public boolean isFree;

        public ParkingSpot(String spotId, boolean isFree) {
            this.spotId = spotId;
            this.isFree = isFree;
        }

}

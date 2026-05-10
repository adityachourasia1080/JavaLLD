package LLD.ParkingLotLLD;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
public class Ticket {
    private String ticketId;
    private ParkingSpot ps;
    private int levelNumber;
    private vehicleType vt;
    public LocalDateTime entryTime;

    public Ticket(ParkingSpot ps, int levelNumber, vehicleType vt) {
        this.ps=ps;
        this.levelNumber = levelNumber;
        this.vt = vt;
        entryTime= LocalDateTime.now();
    }
}

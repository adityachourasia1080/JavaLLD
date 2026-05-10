package LLD.ParkingLotLLD.spotManagers;

import LLD.ParkingLotLLD.ParkingSpot;
import LLD.ParkingLotLLD.parkingstrategy.ParkingStrategy;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class TwoWheelerSpotManager implements PsManager {

    public List<ParkingSpot> twoWheelerSpots;
    private ParkingStrategy strategy;
    private static final ReentrantLock lock= new ReentrantLock();

     public TwoWheelerSpotManager(ParkingStrategy strategy) {
        this.twoWheelerSpots = new ArrayList<>();
        this.strategy = strategy;
    }


    public void addParkingSpot(ParkingSpot spot) {
        lock.lock();
        try {
            if (!twoWheelerSpots.contains(spot)) {
                twoWheelerSpots.add(spot);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public ParkingSpot parkVehicle() {
         lock.lock();ParkingSpot spot = null;

         try{
              spot= strategy.findParkingSpot(twoWheelerSpots);
              spot.isFree = false;
              return spot;
         }
         finally {
                 lock.unlock();
         }

     }

    @Override
    public void unparkVehicle(ParkingSpot PS) {
        lock.lock();
        try {
            for (ParkingSpot  ps : twoWheelerSpots) {
                if (ps.getSpotId() == PS.getSpotId()) {
                    ps.isFree = true;
                    break;
                }
            }
        }
        finally {
            lock.unlock();
        }

    }

    @Override
    public boolean isParkingSpotFree() {
        lock.lock();
        try {
            for (ParkingSpot ps : twoWheelerSpots) {
                if (ps.isFree()) {
                    return true;
                }
            }
            return false;
        }
        finally {
            lock.unlock();
        }
    }
}

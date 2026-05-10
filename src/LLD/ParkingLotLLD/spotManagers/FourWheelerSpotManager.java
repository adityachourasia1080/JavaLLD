package LLD.ParkingLotLLD.spotManagers;

import LLD.ParkingLotLLD.ParkingSpot;
import LLD.ParkingLotLLD.parkingstrategy.ParkingStrategy;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class FourWheelerSpotManager implements PsManager{

    public List<ParkingSpot> fourWheelerSpots;
    public ParkingStrategy strategy;
    private static final ReentrantLock lock= new ReentrantLock();

     public FourWheelerSpotManager(List<ParkingSpot> fourWheelerSpots, ParkingStrategy strategy) {
        this.fourWheelerSpots = fourWheelerSpots;
        this.strategy = strategy;
    }
    @Override
    public ParkingSpot parkVehicle() {
        lock.lock();
        try {
            ParkingSpot spot = strategy.findParkingSpot(fourWheelerSpots);
            if (spot != null) {
                spot.isFree = false;
            }
            return spot;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void unparkVehicle(ParkingSpot PS) {
        lock.lock();
        try {
            for (ParkingSpot ps : fourWheelerSpots) {
                if (ps.getSpotId().equals(PS.getSpotId())) {
                    ps.isFree = true;
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isParkingSpotFree() {
        lock.lock();
        try {
            for (ParkingSpot ps : fourWheelerSpots) {
                if (ps.isFree()) {
                    return true;
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}

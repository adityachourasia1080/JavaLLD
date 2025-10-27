package LLD.ParkingLotLLD.ParkingManagerHandler;


public interface ParkingSpotManager {

    int findSpace(VehicleType v) throws Exception;

    void freeSpace(VehicleType v);

}

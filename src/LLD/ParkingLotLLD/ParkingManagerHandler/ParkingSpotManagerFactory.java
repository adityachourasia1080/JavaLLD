//package LLD.ParkingLotLLD.ParkingManagerHandler;
//
//
//public class ParkingSpotManagerFactory {
//
//    public ParkingSpotManager twoW;
//    public ParkingSpotManager fourW;
//
//    public ParkingSpotManagerFactory() {
//        twoW  = new ParkingSpotManager2w();
//        fourW = new ParkingSpotManger4w();
//    }
//
//    public int getParkingSpot(VehicleType v) {
//        return switch (v) {
//            case VehicleType.TWO_WHEELER -> twoW.findSpace(v);
//            case VehicleType.FOUR_WHEELER -> fourW.findSpace(v);
//            default -> throw new IllegalArgumentException("Invalid vehicle type: " + v);
//        };
//    }
//}

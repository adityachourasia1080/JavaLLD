package LLD.DesignPatterns.NullObjectPattern;

public class Main {

    public static void main(String[] args){
        VehicleFactory fac= new VehicleFactory();
        Vehicle truck= fac.getVehicleObj("truck");
        truck.start();
    }
}

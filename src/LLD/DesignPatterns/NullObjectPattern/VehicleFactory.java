package LLD.DesignPatterns.NullObjectPattern;

public class VehicleFactory {

    public Vehicle getVehicleObj(String type){
        if (type.equalsIgnoreCase("CAR")){
            return new Car("RED",9);
        }
        else{
            return new NullVehicle();
        }
    }
}

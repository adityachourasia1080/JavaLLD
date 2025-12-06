package LLD.DesignPatterns.NullObjectPattern;

public class NullVehicle implements Vehicle{
    String color="deafault";
    int seatingCapacity=0;

    @Override
    public void start() {
        //do nothing
    }

    @Override
    public void stop() {
        // do nothing
    }
}

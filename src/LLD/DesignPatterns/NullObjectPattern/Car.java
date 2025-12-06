package LLD.DesignPatterns.NullObjectPattern;

public class Car implements Vehicle{

    String color ;
    int seatingCapacity;

    public Car(String color,int capacity){
        this.color=color;
        this.seatingCapacity=capacity;
    }


    @Override
    public void start() {
        System.out.println("Car is starting");
    }

    @Override
    public void stop() {
        System.out.println("Car is stoping");
    }
}

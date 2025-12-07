package LLD.DesignPatterns.StateDesignPattern;

public class RedState implements TrafficLightState{

    @Override
    public void action(TrafficLight signal) {
        System.out.println("State is Red Changing it to Green");
        signal.setState(new GreenState());

    }
}

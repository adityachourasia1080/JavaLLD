package LLD.DesignPatterns.StateDesignPattern;

public class GreenState implements TrafficLightState{

    @Override
    public void action(TrafficLight signal) {
        System.out.println("State is Green Changing it to Yellow");
        signal.setState(new YellowState());

    }
}

package LLD.DesignPatterns.StateDesignPattern;

public class YellowState implements TrafficLightState{

    @Override
    public void action(TrafficLight signal) {
        System.out.println("State is Yellow Changing it to Red");
        signal.setState(new RedState());
    }
}

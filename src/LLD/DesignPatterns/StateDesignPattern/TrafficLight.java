package LLD.DesignPatterns.StateDesignPattern;

public class TrafficLight {

    public TrafficLightState state;
    public TrafficLight() {
        state = new RedState();
    }

    public void setState(TrafficLightState s){
        this.state=s;
    }

    public void change(){
        state.action(this);
    }
}

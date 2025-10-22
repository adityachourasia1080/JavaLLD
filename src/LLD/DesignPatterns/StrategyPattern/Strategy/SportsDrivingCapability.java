package LLD.DesignPatterns.StrategyPattern.Strategy;

public class SportsDrivingCapability implements DriveStrategy {

    @Override
    public void drive(){
        System.out.println("Sports Driving capability is live");
    }
}

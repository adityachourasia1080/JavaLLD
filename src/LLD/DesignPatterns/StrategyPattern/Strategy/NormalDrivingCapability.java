package LLD.DesignPatterns.StrategyPattern.Strategy;

public class NormalDrivingCapability implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Normal Driving capability is live");
    }
}

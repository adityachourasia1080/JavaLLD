package LLD.DesignPatterns.StrategyPattern.Shreyensh;

import LLD.DesignPatterns.StrategyPattern.Shreyensh.Strategy.SportsDrivingCapability;

public class OffRoadVehicle extends Vehicle {

    public OffRoadVehicle() {
            super(new SportsDrivingCapability());
        }
}

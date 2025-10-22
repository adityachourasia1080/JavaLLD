package LLD.DesignPatterns.StrategyPattern;

import LLD.DesignPatterns.StrategyPattern.Strategy.DriveStrategy;
import LLD.DesignPatterns.StrategyPattern.Strategy.SportsDrivingCapability;

public class OffRoadVehicle extends Vehicle{

    public OffRoadVehicle() {
            super(new SportsDrivingCapability());
        }
}

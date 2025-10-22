package LLD.DesignPatterns.StrategyPattern;

import LLD.DesignPatterns.StrategyPattern.Strategy.DriveStrategy;
import LLD.DesignPatterns.StrategyPattern.Strategy.SportsDrivingCapability;

public class SportsVehicle extends Vehicle {

        public SportsVehicle() {
            super(new SportsDrivingCapability());
        }
}

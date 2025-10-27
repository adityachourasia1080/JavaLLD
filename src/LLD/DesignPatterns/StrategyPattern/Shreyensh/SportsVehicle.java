package LLD.DesignPatterns.StrategyPattern.Shreyensh;

import LLD.DesignPatterns.StrategyPattern.Shreyensh.Strategy.SportsDrivingCapability;

public class SportsVehicle extends Vehicle {

        public SportsVehicle() {
            super(new SportsDrivingCapability());
        }
}

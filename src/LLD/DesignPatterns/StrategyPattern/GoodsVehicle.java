package LLD.DesignPatterns.StrategyPattern;

import LLD.DesignPatterns.StrategyPattern.Strategy.DriveStrategy;
import LLD.DesignPatterns.StrategyPattern.Strategy.NormalDrivingCapability;

public class GoodsVehicle extends Vehicle{

        public GoodsVehicle() {
            super(new NormalDrivingCapability());
    }
}

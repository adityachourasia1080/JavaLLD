package LLD.DesignPatterns.StrategyPattern.Shreyensh;

import LLD.DesignPatterns.StrategyPattern.Shreyensh.Strategy.NormalDrivingCapability;

public class GoodsVehicle extends Vehicle {

        public GoodsVehicle() {
            super(new NormalDrivingCapability());
    }
}

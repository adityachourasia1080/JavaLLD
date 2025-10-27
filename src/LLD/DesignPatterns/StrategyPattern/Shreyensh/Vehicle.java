package LLD.DesignPatterns.StrategyPattern.Shreyensh;

import LLD.DesignPatterns.StrategyPattern.Shreyensh.Strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy obj;

    public Vehicle(DriveStrategy obj){
        this.obj=obj;
    }

    public void drive(){
        this.obj.drive();
    }
}

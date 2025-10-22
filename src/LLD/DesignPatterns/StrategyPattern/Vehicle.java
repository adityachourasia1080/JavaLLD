package LLD.DesignPatterns.StrategyPattern;

import LLD.DesignPatterns.StrategyPattern.Strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy obj;

    public Vehicle(DriveStrategy obj){
        this.obj=obj;
    }

    public void drive(){
        this.obj.drive();
    }
}

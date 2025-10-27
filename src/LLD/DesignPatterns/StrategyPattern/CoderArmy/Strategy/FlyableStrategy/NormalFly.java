package LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.FlyableStrategy;

public class NormalFly implements Flyable{
    @Override
    public void fly() {
        System.out.println("Hi i can FLY");
    }
}

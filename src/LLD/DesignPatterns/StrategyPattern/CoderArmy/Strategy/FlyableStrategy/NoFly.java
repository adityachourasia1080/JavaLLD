package LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.FlyableStrategy;

public class NoFly implements Flyable{
    @Override
    public void fly() {
        System.out.println("Hi All i cannot fly");
    }
}

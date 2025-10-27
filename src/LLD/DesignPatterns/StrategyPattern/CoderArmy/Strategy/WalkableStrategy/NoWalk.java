package LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.WalkableStrategy;

public class NoWalk implements Walkable {
    @Override
    public void walk() {
        System.out.println("I cannot walk");
    }
}

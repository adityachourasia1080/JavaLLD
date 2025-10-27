package LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.TalkableStrategy;

public class NoTalk implements Talkable {
    @Override
    public void Talk() {
        System.out.println("I cannot talk");
    }
}

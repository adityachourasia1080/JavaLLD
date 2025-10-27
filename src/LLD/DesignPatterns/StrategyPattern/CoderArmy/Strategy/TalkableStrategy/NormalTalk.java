package LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.TalkableStrategy;

public class NormalTalk implements Talkable {
    @Override
    public void Talk() {
        System.out.println("Hi Buddy i can talk");
    }
}

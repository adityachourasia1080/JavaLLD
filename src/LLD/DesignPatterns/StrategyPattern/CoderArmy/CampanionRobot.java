package LLD.DesignPatterns.StrategyPattern.CoderArmy;

import LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.FlyableStrategy.Flyable;
import LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.TalkableStrategy.Talkable;
import LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.WalkableStrategy.Walkable;

public class CampanionRobot extends Robot{

    public CampanionRobot(Flyable f1, Walkable w1, Talkable t1) {
        super(f1, w1, t1);
    }

    @Override
    public void projection() {
        System.out.println("Look i am campanion Robot projection");
    }
}

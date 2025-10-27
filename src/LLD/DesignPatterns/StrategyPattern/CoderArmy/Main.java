package LLD.DesignPatterns.StrategyPattern.CoderArmy;

import LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.FlyableStrategy.NoFly;
import LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.FlyableStrategy.NormalFly;
import LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.TalkableStrategy.NormalTalk;
import LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.WalkableStrategy.NoWalk;
import LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.WalkableStrategy.NormalWalk;

public class Main {

    public static void main(String[] args){
        Robot robot= new CampanionRobot(new NoFly(),new NormalWalk(),new NormalTalk());
        robot.fly();
        robot.walk();

        Robot rb= new SparrowRobot(new NormalFly(), new NoWalk(), new NormalTalk());
        rb.projection();
        rb.walk();
    }
}

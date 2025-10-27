package LLD.DesignPatterns.StrategyPattern.CoderArmy;

import LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.FlyableStrategy.Flyable;
import LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.TalkableStrategy.Talkable;
import LLD.DesignPatterns.StrategyPattern.CoderArmy.Strategy.WalkableStrategy.Walkable;

public abstract class Robot {

    Flyable f1;
    Walkable w1;
    Talkable t1;

    public Robot(Flyable f1,Walkable w1, Talkable t1){
        this.f1=f1;
        this.w1=w1;
        this.t1=t1;
    }

    public void walk(){
        w1.walk();
    }

    public void talk(){
        t1.Talk();
    }

    public void fly(){
        f1.fly();
    }

    public abstract void projection();
}

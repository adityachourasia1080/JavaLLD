package LLD.DesignPatterns.DecoratorPattern.Decorator;

import LLD.DesignPatterns.DecoratorPattern.BasePizza;

public abstract class ToppingDecorator implements BasePizza {

    BasePizza pizza;
    public ToppingDecorator(BasePizza pizza){
        this.pizza=pizza;
    }
}

package LLD.DesignPatterns.DecoratorPattern.Decorator;

import LLD.DesignPatterns.DecoratorPattern.BasePizza;

public class CheeseTopping extends ToppingDecorator {

    public CheeseTopping(BasePizza pizza){
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription()+" Extra cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost()+20.98;
    }
}

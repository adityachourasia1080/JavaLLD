package LLD.DesignPatterns.DecoratorPattern.Decorator;

import LLD.DesignPatterns.DecoratorPattern.BasePizza;

public class MushroomTopping extends ToppingDecorator{

    public MushroomTopping(BasePizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+" MushroomTopping";
    }

    @Override
    public double getCost() {
        return pizza.getCost()+30.98;
    }
}

package LLD.DesignPatterns.DecoratorPattern;

import LLD.DesignPatterns.DecoratorPattern.Decorator.CheeseTopping;
import LLD.DesignPatterns.DecoratorPattern.Decorator.MushroomTopping;

public class Main {

    public static void main(String[] args){

        BasePizza pizza1 = new CheeseTopping(new Farmhouse());
        System.out.println(pizza1.getDescription()+" "+ pizza1.getCost());

        BasePizza pizza2= new MushroomTopping(new CheeseTopping(new CheeseTopping(new MushroomTopping(new Farmhouse()))));
        System.out.println(pizza2.getDescription()+" "+pizza2.getCost());
    }
}

package LLD.DesignPatterns.DecoratorPattern;

public class PlainPizza implements BasePizza{
    @Override
    public String getDescription() {
        return "PlainPizza";
    }

    @Override
    public double getCost() {
        return 100.00;
    }
}

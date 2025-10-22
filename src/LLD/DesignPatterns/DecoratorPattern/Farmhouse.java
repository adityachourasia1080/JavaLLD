package LLD.DesignPatterns.DecoratorPattern;

public class Farmhouse implements BasePizza{
    @Override
    public String getDescription() {
        return "FarmHouse pizza";
    }

    @Override
    public double getCost() {
        return 200.00;
    }
}

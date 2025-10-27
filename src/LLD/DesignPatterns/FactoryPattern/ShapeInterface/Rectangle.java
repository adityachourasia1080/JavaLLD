package LLD.DesignPatterns.FactoryPattern.ShapeInterface;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("New Rectangle Object initiated ");
    }
}

package LLD.DesignPatterns.FactoryPattern.ShapeInterface;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("New Circle Object initiated ");
    }
}

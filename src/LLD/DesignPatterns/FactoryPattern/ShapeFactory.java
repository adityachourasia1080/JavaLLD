package LLD.DesignPatterns.FactoryPattern;

import LLD.DesignPatterns.FactoryPattern.ShapeInterface.Circle;
import LLD.DesignPatterns.FactoryPattern.ShapeInterface.Rectangle;
import LLD.DesignPatterns.FactoryPattern.ShapeInterface.Shape;

public class ShapeFactory {

    Shape getShape(String input){
        return switch (input) {
            case "CIRCLE" -> new Circle();
            case "RECTANGLE" -> new Rectangle();
            default -> null;
        };
    }
}

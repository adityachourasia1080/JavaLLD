package LLD.DesignPatterns.FactoryPattern;

import LLD.DesignPatterns.FactoryPattern.ShapeInterface.Shape;

public class Main {
    public static void main(String[] args){
        ShapeFactory shapeFactoryobj = new ShapeFactory();
        Shape obj =shapeFactoryobj.getShape("CIRCLE");
        obj.draw();
    }
}

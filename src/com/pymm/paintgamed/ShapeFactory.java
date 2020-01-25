package com.pymm.paintgamed;

import com.pymm.paintgamed.shapes.Circle;
import com.pymm.paintgamed.shapes.Rectangle;
import com.pymm.paintgamed.shapes.Shape;
import com.pymm.paintgamed.shapes.Triangle;
import javafx.scene.paint.Color;

public class ShapeFactory {
    private static ShapeFactory instance;

    private ShapeFactory(){

    }

    public static ShapeFactory getInstance(){
        if(instance == null){
            instance = new ShapeFactory();
        }
        return instance;
    }

    public Shape createShape(String shapeType, double x, double y, Color color){
        if(shapeType.equalsIgnoreCase("circle")){
            Circle circle = new Circle();
            circle.setX(x - Circle.RADIUS/2);
            circle.setY(y - Circle.RADIUS/2);
            circle.setColor(color);
            return circle;
        }
        if(shapeType.equalsIgnoreCase("rectangle")){
            Rectangle rectangle = new Rectangle();
            rectangle.setX(x - Rectangle.WIDTH/2);
            rectangle.setY(y - Rectangle.HEIGHT/2);
            rectangle.setColor(color);
            return rectangle;
        }
        if(shapeType.equalsIgnoreCase("triangle")){
            Triangle triangle = new Triangle();
            triangle.setX(x);
            triangle.setY(y);
            triangle.setColor(color);
            return triangle;
        }

        return null;
    }
}

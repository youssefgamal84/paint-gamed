package com.pymm.paintgamed.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;


public class Rectangle extends Shape {
    private Paint color;
    public static final int WIDTH = 100, HEIGHT = 50;

    @Override
    public void draw(GraphicsContext gc) {
        Paint originalColor = gc.getFill();
        gc.setFill(color);
        gc.fillRect(x, y, WIDTH, HEIGHT);
        gc.setFill(originalColor);
    }

    @Override
    public void update(Paint color) {
        this.color = color;
    }

    public void setColor(Paint color){
        update(color);
    }

}

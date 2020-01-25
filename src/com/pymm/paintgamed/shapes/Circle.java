package com.pymm.paintgamed.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Circle extends Shape {
    public static final int RADIUS = 50;

    @Override
    public void draw(GraphicsContext gc) {
        Paint originalColor = gc.getFill();
        gc.setFill(color);
        gc.fillOval(x, y, RADIUS, RADIUS);
        gc.setFill(originalColor);
    }

    @Override
    public void update(Paint color) {

    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

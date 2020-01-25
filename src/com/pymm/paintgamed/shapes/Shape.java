package com.pymm.paintgamed.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public abstract class Shape {
    protected double x,y;
    protected Paint color;

    public abstract void draw(GraphicsContext gc);

    public abstract void update(Paint color);

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    public Paint getColor() {
        return color;
    }
}

package com.pymm.paintgamed.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Triangle extends Shape {
    private double x,y;
    private static final double WIDTH = 50, HEIGHT = 43.3;

    @Override
    public void draw(GraphicsContext gc) {
        double firstX = x;
        double secondX = x - (WIDTH/2);
        double thirdX = x + (WIDTH/2);

        double firstY = y - (HEIGHT/2);
        double secondAndThirdY = y + (HEIGHT/2);

        Paint originalColor = gc.getFill();
        gc.setFill(color);
        gc.fillPolygon(new double[]{firstX, secondX,thirdX},
                new double[]{firstY, secondAndThirdY, secondAndThirdY}, 3);
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

package com.pymm.paintgamed.commands;

import com.pymm.paintgamed.shapes.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;

public class ChangleAllColorsCommand implements Command {
    GraphicsContext gc;
    List<Shape> shapes;
    Paint color;
    List<Paint> colors;

    public ChangleAllColorsCommand(GraphicsContext gc, List<Shape> shapes, Paint color) {
        this.gc = gc;
        this.shapes = shapes;
        this.color = color;
        colors = new ArrayList<>();
        for(Shape shape: shapes){
            colors.add(shape.getColor());
        }
    }

    @Override
    public void execute() {
        for(Shape shape: shapes){
            shape.setColor(color);
        }
    }

    @Override
    public void unexecute() {
        for(int i =0; i < colors.size(); i++){
            shapes.get(i).setColor(colors.get(i));
        }
    }
}

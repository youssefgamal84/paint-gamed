package com.pymm.paintgamed.commands;

import com.pymm.paintgamed.shapes.Shape;

import java.util.List;

public class AddShapeCommand implements Command {
    private List<Shape> shapes;
    private Shape shape;

    public AddShapeCommand(List<Shape> shapes, Shape shape) {
        this.shapes = shapes;
        this.shape = shape;
    }

    @Override
    public void execute() {
        shapes.add(shape);
    }

    @Override
    public void unexecute() {
        shapes.remove(shapes.size() - 1);
    }
}

package com.pymm.paintgamed;

import com.pymm.paintgamed.commands.AddShapeCommand;
import com.pymm.paintgamed.commands.ChangleAllColorsCommand;
import com.pymm.paintgamed.commands.Command;
import com.pymm.paintgamed.shapes.Shape;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main extends Application {
    StackPane pane = new StackPane();
    Scene scene = new Scene(pane, 800, 500);
    Canvas canvas = new Canvas(800, 500);
    GraphicsContext gc;
    ColorPicker colorPicker = new ColorPicker();
    GridPane gridPane = new GridPane();
    ChoiceBox choiceBox = new ChoiceBox();
    Button changeAllColors = new Button();
    Button undoButton = new Button();
    Button redoButton = new Button();


    List<Shape> shapes = new ArrayList<>();
    Stack<Command> commandsToUndo = new Stack<>();
    Stack<Command> commandsToRedo = new Stack<>();

    @Override
    public void start(Stage stage) throws Exception {
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        scene.setOnMousePressed(event -> {
            Shape shape = ShapeFactory.getInstance().createShape((String) choiceBox.getValue(), event.getSceneX(),
                    event.getSceneY(), colorPicker.getValue());
            shape.draw(gc);
            Command command = new AddShapeCommand(shapes, shape);
            command.execute();
            commandsToUndo.push(command);
            commandsToRedo.clear();
        });


        choiceBox.getItems().add("circle");
        choiceBox.getItems().add("triangle");
        choiceBox.getItems().add("rectangle");
        choiceBox.setValue("circle");

        changeAllColors.setText("Changle all colors");
        changeAllColors.setOnAction(event -> {
            clearGraphics();
            Command command = new ChangleAllColorsCommand(gc, shapes, colorPicker.getValue());
            command.execute();
            commandsToUndo.push(command);
            redrawShapes();
            commandsToRedo.clear();
        });

        undoButton.setText("UNDO");
        undoButton.setOnAction(event -> {
            if(commandsToUndo.isEmpty()) return;
            Command command = commandsToUndo.pop();
            clearGraphics();
            command.unexecute();
            redrawShapes();
            commandsToRedo.add(command);
        });

        redoButton.setText("REDO");
        redoButton.setOnAction(event -> {
            if(commandsToRedo.isEmpty()) return;
            Command command = commandsToRedo.pop();
            clearGraphics();
            command.execute();
            redrawShapes();
            commandsToUndo.add(command);
        });

        colorPicker.setValue(Color.BLACK);
        colorPicker.setOnAction(event -> {
            gc.setStroke(colorPicker.getValue());
            gc.setFill(colorPicker.getValue());
        });

        gridPane.addRow(0, colorPicker, changeAllColors, choiceBox, undoButton, redoButton);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 0, 0, 0));

        pane.getChildren().addAll(canvas, gridPane);

        stage.setScene(scene);
        stage.show();
    }

    private void redrawShapes() {
        for(Shape shape: shapes){
            shape.draw(gc);
        }
    }

    private void clearGraphics() {
        gc.clearRect(0,0,800,500);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

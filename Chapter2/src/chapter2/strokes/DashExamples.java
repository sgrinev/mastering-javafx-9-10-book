/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter2.strokes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class DashExamples extends Application {

    private VBox root = new VBox(50);

    private Line addLine() {
        Line line = new Line(50, 0, 250, 0);
        line.setStrokeWidth(10);
        line.setStroke(Color.DARKGRAY);
        line.getStrokeDashArray().addAll(30.0, 15.0);
        root.getChildren().add(line);
        return line;
    }

    @Override
    public void start(Stage primaryStage) {
        root.setPadding(new Insets(30));

        addLine().setStrokeLineCap(StrokeLineCap.SQUARE);

        addLine().setStrokeLineCap(StrokeLineCap.BUTT);

        addLine().setStrokeLineCap(StrokeLineCap.ROUND);

        Line line = addLine();
        line.setStrokeLineCap(StrokeLineCap.SQUARE);
        line.setStrokeDashOffset(20);

        primaryStage.setTitle("Dashes");
        primaryStage.setScene(new Scene(root, 300, 350));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

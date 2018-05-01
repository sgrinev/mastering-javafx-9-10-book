/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter2.strokes;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class LineJoins extends Application {

    private Path newPath() {
        Path path = new Path(
                new MoveTo(0, 0), new HLineTo(100),
                new LineTo(70, 30), new ClosePath());
        path.setStroke(Color.DARKGRAY);
        path.setStrokeWidth(10);
        return path;
    }

    @Override
    public void start(Stage primaryStage) {

        FlowPane root = new FlowPane(20, 40);
        root.setPadding(new Insets(20));
        for (StrokeLineJoin value : StrokeLineJoin.values()) {
            Path path = newPath();
            path.setStrokeLineJoin(value);
            root.getChildren().add(new VBox(10, new Text(value.name()), path));
        }

        primaryStage.setTitle("Dashes");
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

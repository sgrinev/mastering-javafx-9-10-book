/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter2.shapes;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class PathDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        ArcTo arcTo = new ArcTo(); // ArcTo is set separately due to its complexity
        arcTo.setRadiusX(250);
        arcTo.setRadiusY(90);
        arcTo.setX(50);
        arcTo.setY(100);
        arcTo.setSweepFlag(true);
        System.out.println(arcTo.getXAxisRotation());

        Path path = new Path(
                new MoveTo(0, 0),
                new HLineTo(50),
                arcTo,
                new VLineTo(150),
                new HLineTo(0),
                new ClosePath()
        );

        SVGPath svgPath = new SVGPath();
        svgPath.setContent("M0,0 H50 A250,90 0 0,1 50,100 V150 H0 Z");
        // M - move, H - horizontal line, A - arc, V - vertical line, Z - close path
        svgPath.setFill(Color.DARKGREY);

        HBox root = new HBox(30, path, svgPath);
        root.setPadding(new Insets(20));

        primaryStage.setTitle("Paths");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

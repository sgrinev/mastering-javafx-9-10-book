/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter2.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class CubicCurveDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        CubicCurve cubic = new CubicCurve();
        cubic.setStartX(50.0);
        cubic.setStartY(200.0);
        cubic.setControlX1(75.0);
        cubic.setControlY1(30.0);
        cubic.setControlX2(135.0);
        cubic.setControlY2(170.0);
        cubic.setEndX(250.0);
        cubic.setEndY(190.0);
        cubic.setFill(Color.DARKGRAY);

        Polyline lines = new Polyline(
                cubic.getStartX(), cubic.getStartY(), 
                cubic.getControlX1(), cubic.getControlY1(), 
                cubic.getControlX2(), cubic.getControlY2(), 
                cubic.getEndX(), cubic.getEndY());

        Pane root = new Pane();
        root.getChildren().addAll(cubic, lines);
        primaryStage.setTitle("Cubic Curve");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class BezierCurves extends Application {

    @Override
    public void start(Stage primaryStage) {
        CubicCurve cubic = new CubicCurve();
        cubic.setStartX(0.0);
        cubic.setStartY(100.0);
        cubic.setControlX1(75.0);
        cubic.setControlY1(0.0);
        cubic.setControlX2(125.0);
        cubic.setControlY2(170.0);
        cubic.setEndX(150.0);
        cubic.setEndY(100.0);
        cubic.setFill(Color.DARKGRAY);

        QuadCurve quad = new QuadCurve();
        quad.setStartX(0.0);
        quad.setStartY(100.0);
        quad.setEndX(100.0);
        quad.setEndY(100.0);
        quad.setControlX(115.0);
        quad.setControlY(0.0);
        quad.setFill(Color.DARKGRAY);

        HBox root = new HBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(cubic, quad);
        primaryStage.setTitle("Bezier Curves");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

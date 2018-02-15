/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter2.shapes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ArcAndEllipse extends Application {

    @Override
    public void start(Stage primaryStage) {
        Ellipse ellipse = new Ellipse();
        ellipse.setRadiusX(60);
        ellipse.setRadiusY(40);
        ellipse.setFill(Color.DARKGREY);

        Arc arc = new Arc();
        arc.setRadiusX(60);
        arc.setRadiusY(40);
        arc.setFill(Color.DARKGREY);
        arc.setStartAngle(45);
        arc.setLength(180);

        HBox root = new HBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(ellipse, arc);
        primaryStage.setTitle("Arc and Ellipse");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

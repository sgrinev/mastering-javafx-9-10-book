/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter2.shapes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ClosedShapes extends Application {

    @Override
    public void start(Stage primaryStage) {
        Rectangle rect = new Rectangle(50, 50);
        rect.setArcHeight(10);
        rect.setArcWidth(10);
        rect.setFill(Color.DARKGREY);

        Circle circle = new Circle(50);
        circle.setFill(Color.DARKGREY);

        Ellipse ellipse = new Ellipse();
        ellipse.setRadiusX(60);
        ellipse.setRadiusY(40);
        ellipse.setFill(Color.DARKGREY);

        Polygon polygon = new Polygon();
        polygon.setFill(Color.DARKGREY);
        polygon.getPoints().addAll(
                0.0, 0.0,
                50.0, 30.0,
                10.0, 60.0);

        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(20));
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(rect, circle, ellipse, polygon);

        primaryStage.setTitle("Closed Shapes");
        primaryStage.setScene(new Scene(hbox, 500, 150));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

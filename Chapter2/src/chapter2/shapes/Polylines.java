/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter2.shapes;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class Polylines extends Application {

    @Override
    public void start(Stage primaryStage) {

        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(
                0.0, 0.0,
                50.0, 30.0,
                10.0, 60.0);

        Polyline polyline2 = new Polyline();
        polyline2.getPoints().addAll(polyline.getPoints());
        polyline2.setFill(Color.DARKGRAY);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(polyline.getPoints());
        polygon.setFill(Color.DARKGRAY);
        polygon.setStroke(Color.BLACK);

        HBox root = new HBox(30);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(polyline, polyline2, polygon);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

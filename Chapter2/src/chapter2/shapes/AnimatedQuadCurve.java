/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter2.shapes;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 */
public class AnimatedQuadCurve extends Application {

    @Override
    public void start(Stage primaryStage) {
        QuadCurve quad = new QuadCurve();
        quad.setStartX(50);
        quad.setStartY(200);
        quad.setEndX(250);
        quad.setEndY(200);
        quad.setControlX(275);
        quad.setControlY(20);
        quad.setFill(Color.DARKGRAY);

        Polyline lines = new Polyline(
                quad.getStartX(), quad.getStartY(), 
                quad.getControlX(), quad.getControlY(), 
                quad.getEndX(), quad.getEndY());

        Line tangent = new Line(quad.getStartX(), quad.getStartY(), quad.getControlX(), quad.getControlY());
        tangent.setStroke(Color.RED);
        tangent.setStrokeWidth(2);
        
        Timeline moveTangent = new Timeline(
            new KeyFrame(Duration.seconds(5), 
                    new KeyValue(tangent.startXProperty(), quad.getControlX()),
                    new KeyValue(tangent.startYProperty(), quad.getControlY()),
                    new KeyValue(tangent.endXProperty(), quad.getEndX()),
                    new KeyValue(tangent.endYProperty(), quad.getEndY())
            ));
        moveTangent.setCycleCount(Timeline.INDEFINITE);
        
        Pane root = new Pane();
        root.getChildren().addAll(quad, lines, tangent);
        primaryStage.setTitle("Bezier Curves Demo");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
        moveTangent.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter5.basics;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 */
public class BasicAnimation extends Application {
    
    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(50, 150, 50, Color.RED);

        // change node.translateXProperty from it's current value to 200
        KeyValue keyValue = new KeyValue(circle.translateXProperty(), 200);
        // over the course of 5 seconds
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(5), keyValue);
        Timeline timeline = new Timeline(
                // starting keyFrame can be skipped, JavaFX prepares it for automatically
                // new KeyFrame(Duration.ZERO, new KeyValue(node.translateXProperty(), node.getTranslateX())), 
                keyFrame);

        Scene scene = new Scene(new Pane(circle), 300, 250);
        stage.setScene(scene);
        stage.show();

        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

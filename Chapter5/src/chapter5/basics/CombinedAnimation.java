/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter5.basics;

import java.util.Map;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.Observable;
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
public class CombinedAnimation extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Circle circle = new Circle(50, 50, 20, Color.RED);
        
        Pane root = new Pane();
        root.getChildren().add(circle);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(5), "point 1", 
                new KeyValue(circle.centerXProperty(), 250));
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(10), "point 2",
                new KeyValue(circle.centerYProperty(), 200));
        Timeline timeline = new Timeline(keyFrame, keyFrame2);
        Scene scene = new Scene(root, 400, 400);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        timeline.play();
        
        // trajectory drawer
        timeline.currentTimeProperty().addListener((Observable duration) -> {
            Circle gray = new Circle(circle.getCenterX(), circle.getCenterY(), 4, Color.LIGHTGRAY);
            root.getChildren().add(gray);
        });


        for (Map.Entry<String, Duration> entry : timeline.getCuePoints().entrySet()) {
            System.out.println(entry.getValue() + ": " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

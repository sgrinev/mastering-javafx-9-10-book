/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter5.basics;

import java.util.Map;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
public class HandlerDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Circle node = new Circle(50, 150, 50, Color.RED);
        
        Pane root = new Pane();
        root.getChildren().add(node);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(5), "point 1", 
                (ActionEvent event) -> {
                    node.setFill(Color.GREEN);
                },
                new KeyValue(node.centerXProperty(), 200));
        
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(10), 
                new KeyValue(node.centerYProperty(), 300));
        
        Timeline timeline = new Timeline(keyFrame, keyFrame2);
        Scene scene = new Scene(root, 400, 400);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

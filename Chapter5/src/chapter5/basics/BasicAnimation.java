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
    public void start(Stage primaryStage) {
        
        Node node = new Circle(50, 150, 50, Color.RED);
        
        KeyValue keyValue = new KeyValue(node.translateXProperty(), 200);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(15), keyValue);
        Timeline timeline = new Timeline(keyFrame);
        
        Scene scene = new Scene(new Pane(node), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

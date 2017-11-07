/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter5.transitions;

import javafx.animation.TranslateTransition;
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
public class TranslateTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Node node = new Circle(50,50, 50, Color.RED);
        TranslateTransition transition = new TranslateTransition(Duration.seconds(5), node);
        transition.setToX(200);
        transition.setFromY(50); 
        transition.setToY(200); 
        
        Scene scene = new Scene(new Pane(node), 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        transition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

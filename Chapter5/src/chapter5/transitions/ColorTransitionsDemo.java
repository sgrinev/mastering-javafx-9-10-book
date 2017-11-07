/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter5.transitions;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 */
public class ColorTransitionsDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Shape circle = new Circle(50, 150, 50);

        FillTransition ft = new FillTransition(Duration.seconds(3), circle, Color.RED, new Color(0, 0, 1, 0.5));
        
        Scene scene = new Scene(new Pane(circle), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        ft.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
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

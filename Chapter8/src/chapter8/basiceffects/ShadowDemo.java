/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter8.basiceffects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ShadowDemo extends Application {

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(50, Color.RED);
        Shadow shadow = new Shadow();
        circle.setEffect(shadow);
        stage.setScene(new Scene(new StackPane(circle), 200, 350));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

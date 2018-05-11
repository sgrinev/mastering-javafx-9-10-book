/*
 * (C) Packt Publishing Ltd, 2017-2018
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

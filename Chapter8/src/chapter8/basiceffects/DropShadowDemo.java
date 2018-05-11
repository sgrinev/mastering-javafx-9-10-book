/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.basiceffects;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class DropShadowDemo extends Application {

    @Override
    public void start(Stage stage) {
        Circle red = new Circle(50, Color.RED);
        red.setEffect(new Shadow());

        Circle yellow = new Circle(50, Color.YELLOW);
        yellow.setEffect(new DropShadow(10, 10, 0, Color.DARKGRAY));

        Circle green = new Circle(50, Color.GREEN);
        green.setEffect(new DropShadow(10, 10, 10, Color.DARKGRAY));
       
        VBox root = new VBox(10, red, yellow, green);
        root.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(root, 200, 350));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

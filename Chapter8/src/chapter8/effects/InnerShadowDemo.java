/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.effects;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class InnerShadowDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Circle red = new Circle(50, Color.RED);
        red.setEffect(new InnerShadow());

        Circle yellow = new Circle(50, Color.YELLOW);
        yellow.setEffect(new InnerShadow(10, 10, 0, Color.BLACK));

        Circle green = new Circle(50, Color.GREEN);
        green.setEffect(new InnerShadow(10, 10, 10, Color.BLACK));
       
        VBox root = new VBox(10, red, yellow, green);
        root.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(root, 200, 350));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

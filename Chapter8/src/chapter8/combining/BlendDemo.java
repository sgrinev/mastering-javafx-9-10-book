/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.combining;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class BlendDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Rectangle r = new Rectangle();
        r.setX(50);
        r.setY(50);
        r.setWidth(50);
        r.setHeight(50);
        r.setFill(Color.BLUE);

        Circle c = new Circle();
        c.setFill(Color.rgb(255, 0, 0, 0.5));
        c.setCenterX(50);
        c.setCenterY(50);
        c.setRadius(25);
        c.setBlendMode(BlendMode.MULTIPLY);

        Group g = new Group();
        g.getChildren().add(r);
        g.getChildren().add(c);

        Scene scene = new Scene(g, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

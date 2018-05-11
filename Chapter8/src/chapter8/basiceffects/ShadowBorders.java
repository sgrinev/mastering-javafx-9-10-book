/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.basiceffects;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ShadowBorders extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(0);
        for (Color color : new Color[] { Color.RED, Color.YELLOW, Color.GREEN}) {
            Circle node = new Circle(50, color);
            node.setEffect(new DropShadow(20, Color.BLACK));
            System.out.println(node.getLayoutBounds());
            System.out.println(node.getBoundsInParent());
            root.getChildren().add(node);
        }
        root.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(root, 200, 350));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

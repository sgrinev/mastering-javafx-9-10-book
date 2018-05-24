/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter1.layoutmanagers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class StackPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new StackPane();
        Rectangle red;
        root.getChildren().addAll(
                new Rectangle(50, 50, Color.GREEN), // is behind blue and invisible
                new Rectangle(75, 75, Color.BLUE),
                red = new Rectangle(90, 90, Color.RED));
        red.toBack();

        Scene scene = new Scene(root, 300, 250);

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

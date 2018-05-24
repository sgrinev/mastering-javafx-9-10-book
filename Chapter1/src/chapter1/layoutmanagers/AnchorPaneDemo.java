/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter1.layoutmanagers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class AnchorPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Rectangle rect = new Rectangle(50, 50, Color.BLUE);

        Pane root = new AnchorPane(rect);
        AnchorPane.setRightAnchor(rect, 20.);
        AnchorPane.setBottomAnchor(rect, 20.);

        Scene scene = new Scene(root, 150, 100);

        primaryStage.setTitle("AnchorPane");
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

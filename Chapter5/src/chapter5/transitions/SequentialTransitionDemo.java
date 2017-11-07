/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter5.transitions;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 */
public class SequentialTransitionDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        RotateTransition rotate = new RotateTransition(Duration.seconds(2));
        rotate.setByAngle(90);

        TranslateTransition translate = new TranslateTransition(Duration.seconds(1));
        translate.setByX(100);

        ScaleTransition scale = new ScaleTransition(Duration.seconds(1));
        scale.setToX(0);
        scale.setToY(0);

        Node node = new Rectangle(50, 50, 100, 30);
        Scene scene = new Scene(new Pane(node), 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        SequentialTransition sequential = new SequentialTransition(
                translate, rotate, new PauseTransition(Duration.seconds(1)), scale);
        sequential.setNode(node);
        sequential.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

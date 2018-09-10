/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter5.app;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 */
public class PlanetDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 300, Color.BLACK);
        Circle sun = new Circle(150, 150, 40, Color.YELLOW);
        Circle earth = new Circle(25, Color.BLUE);

        Ellipse orbit = new Ellipse(150, 150, 125, 50);
        PathTransition pt = new PathTransition(Duration.seconds(5), orbit, earth);
        pt.setInterpolator(Interpolator.LINEAR);
        pt.setCycleCount(Timeline.INDEFINITE);

        ScaleTransition st = new ScaleTransition(Duration.millis(2500), earth);
        st.setDelay(Duration.millis(1250));
        st.setToX(0.6);
        st.setToY(0.6);
        st.setAutoReverse(true);
        st.setCycleCount(Timeline.INDEFINITE);

        Timeline front = new Timeline(
                new KeyFrame(Duration.millis(0), (event) -> earth.toFront()),
                new KeyFrame(Duration.millis(2500), (event) -> earth.toBack()),
                new KeyFrame(Duration.seconds(5))
        );
        front.setCycleCount(Timeline.INDEFINITE);

        root.getChildren().addAll(sun, earth);

        primaryStage.setScene(scene);
        primaryStage.show();

        ParallelTransition parallel = new ParallelTransition(pt, st, front);
        parallel.playFrom(Duration.millis(1250));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

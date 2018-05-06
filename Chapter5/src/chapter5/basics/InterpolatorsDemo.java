/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter5.basics;

import java.util.stream.Stream;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 */
public class InterpolatorsDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);

        Stream.of(
            Interpolator.LINEAR,
            Interpolator.EASE_IN,
            Interpolator.EASE_BOTH,
            Interpolator.EASE_OUT
        ).forEach((interpolator)-> {
            Circle node = new Circle(30, Color.RED);
            root.getChildren().add(node);
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), 
                    new KeyValue(node.translateXProperty(), 240, interpolator));
            timeline.getKeyFrames().add(keyFrame);
        });
        
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("click to start");
        primaryStage.show();
        System.out.println(timeline.getStatus());
        root.setOnMouseClicked((event) -> {
            if (timeline.getStatus() == Animation.Status.RUNNING) 
                timeline.pause(); 
            else 
                timeline.play();});
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

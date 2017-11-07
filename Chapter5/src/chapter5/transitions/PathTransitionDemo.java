/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter5.transitions;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 */
public class PathTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        SVGPath svgPath = new SVGPath();
        svgPath.setFill(Color.LIGHTGRAY);
        svgPath.setContent("M30,30 H80 A280,120 0 0,1 80,130 V180 H30 Z");
        
        Node node = new Circle(10, Color.BLACK);
        PathTransition pt = new PathTransition(Duration.seconds(4), svgPath, node);
        //PathTransition pt = new PathTransition(Duration.seconds(4), new Circle(100, 100, 50), node);
        
        Pane pane = new Pane(svgPath, node);
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        pt.play();
        
        pane.setOnMouseClicked((e) -> pt.play());
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

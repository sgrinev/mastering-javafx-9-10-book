/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter5.transitions;

import javafx.animation.RotateTransition;
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
public class RotateTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Node node = new Rectangle(50,50,120,80);
        RotateTransition rt = new RotateTransition(Duration.seconds(3), node);
        rt.setByAngle(180);
        //rt.setAxis(new javafx.geometry.Point3D(70, 80, 100));
        rt.play();
        
        Pane pane = new Pane(node);
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

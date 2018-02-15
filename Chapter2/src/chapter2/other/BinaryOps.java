/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter2.other;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class BinaryOps extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox(40);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        
        Circle circle = new Circle(30);
        Rectangle rect = new Rectangle(45, 45);
        
        root.getChildren().addAll(
                Shape.union(circle, rect),
                Shape.intersect(circle, rect),
                Shape.subtract(circle, rect)
                );

        primaryStage.setTitle("Bezier Curves");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

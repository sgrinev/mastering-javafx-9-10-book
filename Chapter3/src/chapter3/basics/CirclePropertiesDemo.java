/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter3.basics;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class CirclePropertiesDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        Circle circle = new Circle(150, 150, 40, Color.ANTIQUEWHITE);
        circle.setStroke(Color.BLACK);

        Slider sliderRadius = new Slider(0, 100, 40);
        sliderRadius.relocate(80, 20);
        sliderRadius.setShowTickLabels(true);
        sliderRadius.setMajorTickUnit(20);
        
        circle.radiusProperty().bind(sliderRadius.valueProperty());
        
        Slider sliderStrokeWidth = new Slider(0, 10, 2);
        sliderStrokeWidth.setShowTickLabels(true);
        sliderStrokeWidth.setMajorTickUnit(2);
        sliderStrokeWidth.relocate(80, 50);
        
        circle.strokeWidthProperty().bind(sliderStrokeWidth.valueProperty());
        
        root.getChildren().addAll(sliderRadius, circle, sliderStrokeWidth);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello Binding!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

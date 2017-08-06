/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package demo;

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
public class F01_circle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        Slider slider = new Slider(10, 100, 40);
        slider.relocate(80, 30);
        
        Circle circle = new Circle(150, 150, 40, Color.ANTIQUEWHITE);
        circle.setStroke(Color.BLACK);
        
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                circle.setRadius(newValue.doubleValue());
            }
        });
        
        root.getChildren().addAll(slider, circle);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello Binding!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

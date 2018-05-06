/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter3.basics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class BidirectionalBindingDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        Slider s1 = new Slider(0, 100, 40);
        Slider s2 = new Slider(0, 100, 40);
        s2.setOrientation(Orientation.VERTICAL);
        s1.valueProperty().bindBidirectional(s2.valueProperty());

        VBox root = new VBox(5, s1, s2);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 200, 150));
        stage.show();
        
        // keep in mind that isBound() doesn't work for bidirectional binding
        System.out.println(s1.valueProperty().isBound()); // false
        System.out.println(s2.valueProperty().isBound()); // false
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

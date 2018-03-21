/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter7.resizing;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class FlowLayoutDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();
        root.setOrientation(Orientation.VERTICAL);
        
        // generating "properties"
        int rnd = 0;
        for (String string : "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".split(" ")) {
            TextField tf = new TextField("value " + rnd++);
            HBox.setHgrow(tf, Priority.ALWAYS); // to make it look better
            HBox hBox = new HBox(5, new Label(string), tf);
            hBox.setPadding(new Insets(5));
            root.getChildren().add(hBox);
        }
        primaryStage.setTitle("FlowPane Demo");
        primaryStage.setScene(new Scene(root, 450, 250));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

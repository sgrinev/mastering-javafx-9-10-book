/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter2.other;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sergey
 */
public class SizeDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(5);
        root.setPadding(new Insets(20));
        Button btnShort = new Button("short button");
        btnShort.setMinWidth(90);
        root.getChildren().addAll(
                new Button("hi"),
                btnShort,
                new Button("medium size button"),
                new Button("very-very-very wide button")
        );
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Sise Demo!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

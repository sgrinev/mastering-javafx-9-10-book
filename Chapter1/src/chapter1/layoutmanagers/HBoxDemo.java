/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.layoutmanagers;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class HBoxDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
HBox hbox = new HBox(5);
hbox.setAlignment(Pos.CENTER);
hbox.getChildren().addAll(
new Rectangle(50, 50, Color.GREEN),
new Rectangle(75, 75, Color.BLUE),
new Rectangle(90, 90, Color.RED));        
        Scene scene = new Scene(hbox, 300, 250);
        
        primaryStage.setTitle("Hello World!");
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

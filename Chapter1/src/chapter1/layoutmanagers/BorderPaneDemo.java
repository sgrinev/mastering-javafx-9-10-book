/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.layoutmanagers;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author sgrinev
 */
public class BorderPaneDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
BorderPane root = new BorderPane();
root.setRight(new Text("Right "));
root.setCenter(new Text("Center"));
root.setBottom(new Text(" Bottom"));
root.setLeft(new Text(" Left"));

Text top = new Text("Top");
root.setTop(top);
BorderPane.setAlignment(top, Pos.CENTER);
root.setStyle("-fx-padding: 5px");

Scene scene = new Scene(root, 300, 250);        
primaryStage.setTitle("BorderPane");
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

/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter2.paint;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ImagePatternDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane root = new StackPane();
        root.getChildren().add(
            new Circle(100, 
                new ImagePattern(
                    new Image("https://upload.wikimedia.org/wikipedia/commons/3/3f/Chimpanzee_congo_painting.jpg"))));
        
        Scene scene = new Scene(root, 300, 250);
        
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

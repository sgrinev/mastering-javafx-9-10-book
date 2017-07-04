package demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class FXApplication extends Application {
    
 
    @Override
    public void init() {
        System.out.println("Before");
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group(), 300, 250);
        stage.setTitle("Hello World!");  
        stage.setScene(scene);
        stage.show();
    }
 
    public void stop() {
        System.out.println("After");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
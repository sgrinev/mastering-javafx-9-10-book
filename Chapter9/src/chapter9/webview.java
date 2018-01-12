/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class webview extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        WebView wv = new WebView();
        wv.getEngine().load("https://stackoverflow.com/questions/tagged/javafx");
        
        StackPane root = new StackPane(wv);
        
        Scene scene = new Scene(root, 400, 250);
        
        primaryStage.setTitle("JavaFX on SO");
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

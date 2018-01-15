/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter9.web;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class WebViewDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        webView.setContextMenuEnabled(true);
//        webView.setZoom(1.2);
//        webView.setFontScale(1.5);
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://stackoverflow.com/questions/tagged/javafx");

        StackPane root = new StackPane(webView);

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

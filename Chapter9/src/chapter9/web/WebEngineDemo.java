/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter9.web;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author sgrinev
 */
public class WebEngineDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        webEngine.setOnAlert((event) -> {
            Stage stage = new Stage((StageStyle.UTILITY));
            stage.setScene(new Scene(new StackPane(new Label(event.getData())), 100, 80));
            stage.show();
        });
        webEngine.setCreatePopupHandler((popupFeatures) -> {
            Stage stage = new Stage((StageStyle.UTILITY));
            WebView webViewPopup = new WebView();
            stage.setScene(new Scene(new StackPane(webViewPopup), 300, 300));
            stage.show();
            return webViewPopup.getEngine();
        });
        webEngine.loadContent("<a href='http://www.stackoverflow.com'>Open StackOverflow</a><input type=button onclick=\"window.alert('hi')\" value='Click Me!'>");


        StackPane root = new StackPane(webView);
        primaryStage.setTitle("JavaFX Web Engine Demo");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

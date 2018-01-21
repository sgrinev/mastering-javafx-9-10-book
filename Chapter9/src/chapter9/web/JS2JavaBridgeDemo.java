/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter9.web;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

/**
 *
 * @author sgrinev
 */
public class JS2JavaBridgeDemo extends Application {
    // declaring root as a variable to have access to it from setColor() method   
    StackPane root;

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        // here we have an HTML page with a text box and a button
        // pressing the button will take entered text value and 
        // pass it to the JavaFX application
        webEngine.loadContent(
                  "<p><input type=text id='color' value='red'/>"
                + "<p><input type=button onclick=\"app.setColor(document.getElementById('color').value)\" value='Click Me!'>");
        JSObject window = (JSObject) webEngine.executeScript("window");
        window.setMember("app", this);


        root = new StackPane(webView);
        // adding padding to have visible part of the background
        root.setPadding(new Insets(10));
        primaryStage.setTitle("JavaFX JavaScript to JavaFX bridge demo");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    // this method we will be calling from JavaScript
    public void setColor(String param) {
        // taking parameter and apply it as a color to the background
        root.setStyle("-fx-background-color: " + param + ";");
    }

    public static void main(String[] args) {
        launch(args);
    }
   
}

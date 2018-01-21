/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter9.web;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author sgrinev
 */
public class DOMModelDemo extends Application {

    @Override
    public void start(Stage stage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://stackoverflow.com/questions/tagged/javafx");

        webEngine.getLoadWorker().stateProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // remember, we need to get the page loaded first
                    if (newValue == Worker.State.SUCCEEDED) {
                        Document document = webEngine.getDocument();
                        NodeList links = webEngine.getDocument().getElementsByTagName("a");
                        for (int i = 0; i < links.getLength(); i++) {
                            System.out.println(links.item(i));
                        }
                    } else if (newValue == Worker.State.FAILED) {
                        System.out.println("Page loading has failed!");
                    } 

                });

        stage.setTitle("JavaFX on SO");
        stage.setScene(new Scene(new StackPane(webView), 400, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

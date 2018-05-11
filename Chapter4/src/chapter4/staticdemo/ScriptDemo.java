/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter4.staticdemo;

import chapter4.script.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ScriptDemo extends Application {

    @Override
    public void start(Stage stage) throws IOException  {
        HBox root = (HBox) FXMLLoader.load(getClass().getResource("ScriptDoc.fxml"));
        Scene scene = new Scene(root, 300, 80);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

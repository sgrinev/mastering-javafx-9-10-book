/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter4.script;

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
public class StaticDemo extends Application {

    @Override
    public void start(Stage stage) throws IOException  {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("StaticDemoDoc.fxml")), 300, 80);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

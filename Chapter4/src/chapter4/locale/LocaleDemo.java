/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter4.locale;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class LocaleDemo extends Application {

    @Override
    public void start(Stage stage) throws IOException  {
        BorderPane root = FXMLLoader.<BorderPane>load(
                getClass().getResource("LocaleDemoDoc.fxml"), ResourceBundle.getBundle("chapter4.demo", new Locale("fr", "FR")));
        Scene scene = new Scene(root, 300, 80);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

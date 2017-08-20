/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class F02_WidthBinding extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label();

        label.textProperty().bind(stage.widthProperty().asString());

        stage.setScene(new Scene(new VBox(10, label), 200, 150));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

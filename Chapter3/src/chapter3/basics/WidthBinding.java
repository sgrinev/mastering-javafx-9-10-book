/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter3.basics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class WidthBinding extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label();

        label.textProperty().bind(stage.widthProperty().asString());

        stage.setScene(new Scene(new StackPane(label), 200, 150));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

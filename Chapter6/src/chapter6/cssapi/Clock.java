/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter6.cssapi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class Clock extends Application {


    @Override
    public void start(Stage stage) {
        final ClockControl cc = new ClockControl();

        Scene scene = new Scene(new StackPane(cc), 400, 350);
        scene.getStylesheets().add(getClass().getResource("clock.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Clock, chapter 6");

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

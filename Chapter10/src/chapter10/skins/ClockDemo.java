/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter10.skins;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ClockDemo extends Application {


    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new HBox(50,
                new ClockControl(ClockControl.SkinType.HANDS),
                new ClockControl(ClockControl.SkinType.TEXT)
        ), 400, 250);
        stage.setScene(scene);
        stage.setTitle("Clock, chapter 10");

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package chapter6.cssapi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author sgrinev
 */
public class Clock extends Application {


    @Override
    public void start(Stage stage) {


        Scene scene = new Scene(new StackPane(new ClockControl()), 400, 350);
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.setTitle("Clock, chapter 2");

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

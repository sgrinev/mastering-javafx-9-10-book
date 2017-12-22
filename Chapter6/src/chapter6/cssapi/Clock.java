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

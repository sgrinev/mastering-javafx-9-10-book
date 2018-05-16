package chapter10.skins;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ClockDemo extends Application {


    @Override
    public void start(Stage stage) {
        final ClockControl cc = new ClockControl();

        Scene scene = new Scene(new StackPane(cc), 400, 350);
        stage.setScene(scene);
        stage.setTitle("Clock, chapter 10");

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

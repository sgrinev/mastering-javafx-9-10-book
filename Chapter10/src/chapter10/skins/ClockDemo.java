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

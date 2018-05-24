/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter1.clock;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author sgrinev
 */
public class ClockOne extends Application {

    // we are allowed to create UI objects on non-UI thread
    private final Text txtTime = new Text();

    private volatile boolean enough = false;

    Thread timer = new Thread(() -> {
        SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
        // we use old-school method for the simplicity here
        // we'll learn how to approach timing JavaFX way in Chapter 5
        while (!enough) {
            final String time = dt.format(new Date());
            Platform.runLater(() -> {
                // updating live UI object requires JavaFX App Thread
                txtTime.setText(time);
            });

            try {
                // running "long" operation not on UI thread
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    });

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setCenter(txtTime);
        txtTime.setFont(Font.font("Verdana", 20));

        Scene scene = new Scene(root, 200, 150);

        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);

        timer.start();
        stage.show();
    }

    @Override
    public void stop() {
        // we need to stop our working thread after closing a window 
        // or our program will not exit
        enough = true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

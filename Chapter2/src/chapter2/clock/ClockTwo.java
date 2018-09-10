/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter2.clock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author sgrinev
 */
public class ClockTwo extends Application {

    private final Text txtTime = new Text();
    private Rotate rotateSecondHand = new Rotate(0, 0, 0);
    private Rotate rotateMinuteHand = new Rotate(0, 0, 0);
    private Rotate rotateHourHand = new Rotate(0, 0, 0);

    private volatile boolean enough = false;

    private final Thread timer = new Thread(() -> {
        // we use old-school method for the simplicity here
        // we'll learn how to approach timing JavaFX way in Chapter 5
        while (!enough) {
            LocalDateTime now = LocalDateTime.now();
            String time = now.format(DateTimeFormatter.ofPattern("HH:MM:ss"));

            Platform.runLater(() -> {
                // updating live UI object requires JavaFX App Thread
                rotateSecondHand.setAngle(now.getSecond() * 6 - 90);
                rotateMinuteHand.setAngle(now.getMinute() * 6 - 90);
                rotateHourHand.setAngle(now.getHour() * 30 - 90);
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

        // create minutes hand
        Path minuteHand = new Path(
                new MoveTo(0, 0),
                new LineTo(15, -5),
                new LineTo(100, 0),
                new LineTo(15, 5),
                new ClosePath());
        minuteHand.setFill(Color.DARKGRAY);
        minuteHand.getTransforms().add(rotateMinuteHand);
        minuteHand.setTranslateX(minuteHand.getBoundsInLocal().getWidth() / 2);

        // create second hand
        Line secondHand = new Line(0, 0, 90, 0);
        secondHand.getTransforms().add(rotateSecondHand);
        secondHand.setTranslateX(secondHand.getBoundsInLocal().getWidth() / 2);

        // create hour hand
        Path hourHand = new Path(
                new MoveTo(0, 0),
                new LineTo(20, -8),
                new LineTo(60, 0),
                new LineTo(20, 8),
                new ClosePath());
        hourHand.setFill(Color.LIGHTGRAY);
        hourHand.getTransforms().add(rotateHourHand);
        hourHand.setTranslateX(hourHand.getBoundsInLocal().getWidth() / 2);

        BorderPane root = new BorderPane();
        root.setCenter(new StackPane(minuteHand, hourHand, secondHand));
        root.setBottom(txtTime);
        BorderPane.setAlignment(txtTime, Pos.CENTER);

        Scene scene = new Scene(root, 400, 350);
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.setTitle("Clock, chapter 2");

        timer.setDaemon(true);
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

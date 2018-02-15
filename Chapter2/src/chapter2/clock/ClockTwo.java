package chapter2.clock;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    private Thread timer = new Thread(() -> {
        SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
        Date now = new Date();
        String time = dt.format(now);

        Platform.runLater(() -> {
            // updating live UI object requires JavaFX App Thread
            rotateSecondHand.setAngle(now.getSeconds() * 6 - 90);
            rotateMinuteHand.setAngle(now.getMinutes() * 6 - 90);
            rotateHourHand.setAngle(now.getHours() * 30 - 90);
            txtTime.setText(time);
        });

        try {
            // running "long" operation not on UI thread
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
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

    public static void main(String[] args) {
        launch(args);
    }
}

package chapter2.strokes;

import java.util.function.Supplier;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class StrokeTypesDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20));

        // a lambda factory to show it's the same rectangle all the time
        Supplier<Rectangle> newRect = () -> new Rectangle(50, 50, Color.LIGHTGRAY);
        hbox.getChildren().add(new VBox(5, new Text("NONE"), newRect.get()));

        for (StrokeType type : StrokeType.values()) {
            Rectangle rect = newRect.get();
            rect.setStrokeType(type);
            rect.setStroke(Color.BLACK);
            rect.setStrokeWidth(10);

            hbox.getChildren().add(new VBox(5, new Text(type.toString()), rect));
        }

        primaryStage.setTitle("Hello StrokeTypes!");
        primaryStage.setScene(new Scene(new StackPane(hbox), 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

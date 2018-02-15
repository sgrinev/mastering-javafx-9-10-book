package chapter2.strokes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class Strokes extends Application {

    @Override
    public void start(Stage primaryStage) {
        Rectangle shape = new Rectangle(400, 100);
        shape.setFill(Color.WHITE);

        shape.setStroke(Color.RED);
        shape.setStrokeWidth(10);
        shape.setStrokeType(StrokeType.CENTERED);

        shape.setStrokeDashOffset(20);
        shape.getStrokeDashArray().addAll(100.0, 50.0);
        shape.setStrokeLineCap(StrokeLineCap.BUTT);
        shape.setStrokeLineJoin(StrokeLineJoin.MITER);
        shape.setStrokeMiterLimit(0);

        StackPane root = new StackPane();
        root.getChildren().add(shape);

        Scene scene = new Scene(root, 600, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

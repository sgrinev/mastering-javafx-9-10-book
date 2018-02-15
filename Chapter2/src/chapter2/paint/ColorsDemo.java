package chapter2.paint;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ColorsDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        root.getChildren().addAll(
                // RED, opacity 0.3
                new Circle(150, 80, 70, Color.rgb(255, 0, 0, 0.3)),
                // GREEN, opacity 0.3
                new Circle(100, 180, 70, Color.hsb(120, 1.0, 1.0, 0.3)),
                // BLUE, opacity 0.3
                new Circle(200, 180, 70, Color.web("0x0000FF", 0.3))
        );

        Scene scene = new Scene(root, 300, 280);

        primaryStage.setTitle("Color Demo");
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

package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class GradientDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Rectangle rect = new Rectangle(100, 200, 400, 200);
        
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.DARKGRAY), new Stop(0.5, Color.ANTIQUEWHITE)};
        LinearGradient lg1 = new LinearGradient(50, 50, 450, 50, false, CycleMethod.NO_CYCLE, stops);
        rect.setFill(lg1);
        
        
        Canvas canvas = new Canvas(600, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.fillText("Stop0 (50)", 50, 75);
        gc.strokeLine(100, 80, 100, 99);
        gc.fillText("Stop1 (450)", 450, 75);
        gc.strokeLine(450, 80, 450, 99);
        gc.fillText("Stop 0.5 (300)", 200, 75);
        gc.strokeLine(100, 80, 100, 99);
        
        StackPane root = new StackPane();
        root.getChildren().addAll(canvas, rect);
        
        Scene scene = new Scene(root, 500, 400);
        
        primaryStage.setTitle("Gradient");
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

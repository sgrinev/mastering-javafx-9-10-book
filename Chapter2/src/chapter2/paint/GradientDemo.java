/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter2.paint;

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

        Rectangle rect = new Rectangle(300, 200);

        Stop[] stops = new Stop[]{
            new Stop(0, Color.BLACK), 
            new Stop(1, Color.ANTIQUEWHITE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 300, 200, false, CycleMethod.NO_CYCLE, stops);
        rect.setFill(lg1);

        StackPane root = new StackPane();
        root.getChildren().addAll(rect);

        Scene scene = new Scene(root, 400, 300);

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

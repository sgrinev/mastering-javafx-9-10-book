/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter8.combining;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ReflectionAndShadows extends Application {
    
    @Override
    public void start(Stage stage) {
        // outer rectangle has a inner shadow
        Rectangle rect = new Rectangle(120, 120);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(4);
        rect.setEffect(new InnerShadow(15, Color.BLACK));

        // text has a drop shadow
        Text text = new Text("FX");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 80));
        text.setEffect(new DropShadow());

        // to apply reflection to both
        // we need to have a common node
        StackPane square = new StackPane(rect, text);
        // this way our StackPane will be small
        // and just wrap the rectangle
        square.setMaxSize(0, 0);

        // aplying reflection
        Reflection reflection = new Reflection();
        reflection.setFraction(0.45);
        square.setEffect(reflection);

        StackPane root = new StackPane(square);
        stage.setTitle("Effects Demo");
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

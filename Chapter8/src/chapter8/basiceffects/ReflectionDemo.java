/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter8.basiceffects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ReflectionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Reflection reflection = new Reflection();
        reflection.setTopOffset(5);
        reflection.setFraction(0.7);
        reflection.setTopOpacity(0.05);
        reflection.setBottomOpacity(0.5);

        Button button = new Button("Button");
        button.setEffect(reflection);

        primaryStage.setTitle("Reflection Demo");
        primaryStage.setScene(new Scene(new StackPane(button), 300, 250));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

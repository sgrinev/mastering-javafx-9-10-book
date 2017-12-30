/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.combining;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class EffectsInput extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Rectangle rect1 = new Rectangle(50, 50, Color.RED);
        DropShadow effect1 = new DropShadow();
        effect1.setInput(new Reflection());
        rect1.setEffect(effect1);

        Rectangle rect2 = new Rectangle(50, 50, Color.RED);
        Reflection effect2 = new Reflection();
        effect2.setInput(new DropShadow());
        rect2.setEffect(effect2);

        HBox root = new HBox(30, rect1, rect2);
        root.setPadding(new Insets(50));
        primaryStage.setTitle("Inputs");
        primaryStage.setScene(new Scene(root, 230, 200));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

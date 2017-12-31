/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.basiceffects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class BlurDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Gaussian Blur");
        btn.setEffect(new GaussianBlur(3));
        Button btn2 = new Button("Motion Blur");
        btn2.setEffect(new MotionBlur(0, 10));
        Button btn3 = new Button("Box Blur");
        btn3.setEffect(new BoxBlur());

        VBox vbox = new VBox(30, btn, btn2, btn3);
        vbox.setPadding(new Insets(50));
        primaryStage.setTitle("Blurry Demo");
        primaryStage.setScene(new Scene(vbox, 300, 250));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

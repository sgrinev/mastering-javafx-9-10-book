/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.combining;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class BlendDiffDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image(
            "https://raw.githubusercontent.com/sgrinev/mastering-javafx-9-10-book/master/resources/sample.jpg", 
            200, 200, true, true);
        ImageInput ii = new ImageInput(image, 0, 0);

        Image image2 = new Image(
            "https://raw.githubusercontent.com/sgrinev/mastering-javafx-9-10-book/master/resources/sample2.jpg", 
            200, 200, true, true);

        Blend blend = new Blend();
        blend.setMode(BlendMode.DIFFERENCE);
        blend.setTopInput(ii);

        ImageView iv = new ImageView(image2);
        iv.setEffect(blend);

        primaryStage.setTitle("Blend Demo");
        primaryStage.setScene(new Scene(new HBox(20, new ImageView(image), iv, new ImageView(image2)), 640, 200));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

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
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class BlendSrcDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image(
            "https://raw.githubusercontent.com/sgrinev/mastering-javafx-9-10-book/master/resources/sample.jpg", 
            300, 300, true, true);
        ImageInput ii = new ImageInput(image, 0, 0);

        Blend blend = new Blend();
        blend.setMode(BlendMode.SRC_ATOP);
        blend.setTopInput(ii);

        Text text = new Text(0, 80, "JavaFX");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        text.setEffect(blend);

        primaryStage.setTitle("Blend Demo");
        primaryStage.setScene(new Scene(new StackPane(text), 300, 300));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

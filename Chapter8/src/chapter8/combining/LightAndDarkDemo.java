/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.combining;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class LightAndDarkDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        final Image image = new Image("https://raw.githubusercontent.com/sgrinev/mastering-javafx-9-10-book/master/resources/sample.jpg", 200, 200, true, true);

        Stop[] stops = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
        LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        ColorInput ci = new ColorInput(0, 0, 200, 200, gradient);

        for (BlendMode value : new BlendMode[] { BlendMode.DARKEN, BlendMode.LIGHTEN}) {
            Blend blend = new Blend();
            blend.setMode(value);

            blend.setTopInput(ci);
            ImageView iv = new ImageView(image);
            iv.setEffect(blend);

            root.getChildren().add(new HBox(10, new Label(value.toString()), iv));
        }

        primaryStage.setTitle("Lighten and Darken");
        primaryStage.setScene(new Scene(root,300, 430));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

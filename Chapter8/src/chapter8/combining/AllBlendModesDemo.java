/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.combining;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class AllBlendModesDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        final Image image = new Image("https://github.com/sgrinev/mastering-javafx-9-book/blob/master/resources/sample.jpg?raw=true", 200, 200, true, true);
        final Image imageC = new Image("https://github.com/sgrinev/mastering-javafx-9-book/blob/master/resources/bwt2.png?raw=true", 200, 200, true, true);
        ImageInput ii = new ImageInput(imageC, 0, 0);

        Stop[] stops = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.GREEN)};
        LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        ColorInput ci = new ColorInput(0, 0, 200, 200, gradient);

        int row = 0;
        for (BlendMode value : BlendMode.values()) {
            // image input demo
            Blend blend = new Blend();
            blend.setMode(value);
            blend.setTopInput(ii);
            ImageView iv = new ImageView(image);
            iv.setEffect(blend);

            // gradient color input demo
            Blend blend2 = new Blend();
            blend2.setMode(value);
            blend2.setTopInput(ci);
            ImageView iv2 = new ImageView(image);
            iv2.setEffect(blend2);

            
            root.add(new Label(value.toString()), 0, row);
            root.add(iv, 1, row);
            root.add(iv2, 2, row);
            row++;
        }

        root.setPadding(new Insets(10));
        primaryStage.setTitle("All Blend Modes");
        primaryStage.setScene(new Scene(new ScrollPane(root), 800, 900));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

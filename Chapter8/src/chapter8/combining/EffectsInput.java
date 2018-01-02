/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.combining;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class EffectsInput extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(1);

        ImageInput ii = new ImageInput(new Image("https://github.com/sgrinev/mastering-javafx-9-book/blob/master/resources/sample.jpg?raw=true", 200, 200, true, true), 0, 0);

        for (BlendMode value : BlendMode.values()) {

            Blend blend = new Blend();
            blend.setMode(value);

            blend.setTopInput(ii);

            Text text = new Text();
            text.setX(15);
            text.setY(65);
            text.setFill(Color.RED);
            text.setText(value.name());
            text.setFont(Font.font(null, FontWeight.BOLD, 50));
            text.setEffect(blend);

            
            Pane g = new Pane(text);
                    g.setMinSize(200, 200);
            root.getChildren().add(g);
        }

//        root.setPadding(new Insets(50));
        primaryStage.setTitle("Inputs");
        primaryStage.setScene(new Scene(new ScrollPane(root), 500, 500));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

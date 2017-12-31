/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.colors;

import java.util.function.Function;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Background;
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
public class BloomGlowDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Function<String,Text> makeLabel = (String name)-> {
            Text label = new Text(name);
            label.setFill(Color.LIGHTBLUE);
            label.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
            return label;
        };

        Text label = makeLabel.apply("JavaFX Bloom");
        label.setEffect(new Bloom(0.8));

        Text label2 = makeLabel.apply("JavaFX Glow");
        label2.setEffect(new Glow(0.8));

        Text label3 = makeLabel.apply("JavaFX Text");

        VBox root = new VBox(5, label, label2, label3);
        root.setPadding(new Insets(20));
        root.setBackground(Background.EMPTY);

        Scene scene = new Scene(root, 400, 250, Color.DARKGRAY);

        primaryStage.setTitle("Bloom or Glow, I don't know...");
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

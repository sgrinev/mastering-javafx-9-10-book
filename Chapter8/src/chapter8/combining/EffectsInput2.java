/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.combining;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class EffectsInput2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button b = new Button("btn");
        Text text = new Text("HELLO");
        
        Group g = new Group();
        g.setEffect(new Blend(BlendMode.ADD));
        g.getChildren().addAll(b, text);
        StackPane root = new StackPane(g);
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

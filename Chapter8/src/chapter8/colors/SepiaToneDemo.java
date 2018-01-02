/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.colors;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class SepiaToneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        ImageView imageView = new ImageView("https://github.com/sgrinev/mastering-javafx-9-book/blob/master/resources/sample.jpg?raw=true");
        imageView.setFitHeight(240);
        imageView.setFitWidth(240);
        SepiaTone st = new SepiaTone();
        imageView.setEffect(st);

        VBox root = new VBox(10);
        Slider slider = new Slider(0, 1, 0.5);
        st.levelProperty().bind(slider.valueProperty());
        root.getChildren().add(new HBox(5, slider, new Label("level")));
        root.getChildren().add(imageView);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        primaryStage.setTitle("Color Adjust Demo");
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

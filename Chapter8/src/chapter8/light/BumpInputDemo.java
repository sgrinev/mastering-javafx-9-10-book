/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.light;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class BumpInputDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // initialize light effect
        Light.Distant light = new Light.Distant();
        light.setAzimuth(100);
        light.setElevation(45);

        // image for bump input
        ImageInput ii = new ImageInput(new Image("https://github.com/sgrinev/mastering-javafx-9-book/blob/master/resources/packt_logo.png?raw=true"), 0, 70);
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setBumpInput(ii);

        // node which we apply effect to
        ImageView iv = new ImageView(new Image("https://github.com/sgrinev/mastering-javafx-9-book/blob/master/resources/sample.jpg?raw=true", 250, 250, true, true));
        iv.setEffect(lighting);

        // service controls
        Slider azimuth = new Slider(0, 360, light.getAzimuth());
        light.azimuthProperty().bind(azimuth.valueProperty());
        
        Slider elevation = new Slider(0, 90, light.getElevation());
        light.elevationProperty().bind(elevation.valueProperty());
        
        VBox root = new VBox(10, 
                new HBox(5, new Label("Azimuth"), azimuth),
                new HBox(5, new Label("Elevation"), elevation),
                iv);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 270, 330);

        primaryStage.setTitle("BumpInput Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

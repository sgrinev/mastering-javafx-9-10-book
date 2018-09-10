/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter8.light;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class LightingDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Light.Distant light = new Light.Distant();
        light.setAzimuth(100);
        light.setElevation(45);

        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5);

        Text text = new Text("FX");
        text.setFill(Color.STEELBLUE);
        text.setFont(Font.font(null, FontWeight.BOLD, 70));

        text.setEffect(lighting);

        Rectangle rect = new Rectangle(70, 70, Color.LIGHTGREEN);
        rect.setEffect(lighting);

        Circle circle = new Circle(60, Color.TRANSPARENT);
        circle.setStroke(Color.DARKGRAY);
        circle.setStrokeWidth(10);
        circle.setEffect(lighting);

        HBox items = new HBox(10, text, rect, circle);
        items.setAlignment(Pos.CENTER);
        items.setPadding(new Insets(20));
        
        Slider azimuth = new Slider(0, 360, light.getAzimuth());
        light.azimuthProperty().bind(azimuth.valueProperty());
        
        Slider elevation = new Slider(0, 90, light.getElevation());
        light.elevationProperty().bind(elevation.valueProperty());
        
        VBox root = new VBox(10, 
                new HBox(5, new Label("Azimuth"), azimuth),
                new HBox(5, new Label("Elevation"), elevation),
                items);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 350, 250);

        primaryStage.setTitle("Lighting Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

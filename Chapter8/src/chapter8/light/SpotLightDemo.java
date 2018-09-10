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
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
public class SpotLightDemo extends Application {
    
    private static Node namedSlider(String name, DoubleProperty prop, double min, double max) {
        Label lbl = new Label(name);
        lbl.setMinWidth(70);
        Slider slider = new Slider(min, max, prop.get());
        prop.bind(slider.valueProperty());
        return new HBox(10, lbl, slider);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(5);
         root.setPadding(new Insets(10));
       
        Light.Spot light = new Light.Spot(300, 250, 500, 1, Color.WHITE);
        light.setPointsAtX(100);
        light.setPointsAtY(100);
        light.setPointsAtZ(0);
        root.getChildren().add(namedSlider("from X", light.xProperty(), -100, 500));
        root.getChildren().add(namedSlider("from Y", light.yProperty(), -100, 500));
        root.getChildren().add(namedSlider("from Z", light.zProperty(), 0, 1000));
        root.getChildren().add(namedSlider("to X", light.pointsAtXProperty(), -100, 500));
        root.getChildren().add(namedSlider("to Y", light.pointsAtYProperty(), -100, 500));
        root.getChildren().add(namedSlider("to Z", light.pointsAtZProperty(), 0, 1000));
        root.getChildren().add(namedSlider("SpecularExp", light.specularExponentProperty(), 0, 4.));
        
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);
        root.getChildren().add(namedSlider("SurfaceScale", lighting.surfaceScaleProperty(), 0, 10));

        Text text = new Text("FX");
        text.setFill(Color.STEELBLUE);
        text.setFont(Font.font(null, FontWeight.BOLD, 70));

        Rectangle rect = new Rectangle(70, 70, Color.LIGHTGREEN);

        Circle circle = new Circle(60, Color.TRANSPARENT);
        circle.setStroke(Color.DARKGRAY);
        circle.setStrokeWidth(10);

        HBox items = new HBox(10, text, rect, circle);
        items.setAlignment(Pos.CENTER);
        items.setPadding(new Insets(20));
        items.setEffect(lighting);

        root.getChildren().add(items);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Lighting Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

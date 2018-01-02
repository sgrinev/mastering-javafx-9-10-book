/*
 * (C) Packt Publishing Ltd, 2017-2018
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class PointLightDemo extends Application {
    
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
       
        Light.Point light = new Light.Point(200, 150, 100, Color.WHITE);
        root.getChildren().add(namedSlider("from X", light.xProperty(), -100, 500));
        root.getChildren().add(namedSlider("from Y", light.yProperty(), -100, 500));
        root.getChildren().add(namedSlider("from Z", light.zProperty(), 0, 1000));
        
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);

        Text text = new Text("Java FX");
        text.setFill(Color.STEELBLUE);
        text.setFont(Font.font(null, FontWeight.BOLD, 70));

        Rectangle rect = new Rectangle(300, 200, Color.BLUE);

        StackPane items = new StackPane(rect, text);
        items.setPadding(new Insets(20));
        items.setEffect(lighting);

        root.getChildren().add(namedSlider("SurfaceScale", lighting.surfaceScaleProperty(), 0, 10));
        root.getChildren().add(items);
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Lighting Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

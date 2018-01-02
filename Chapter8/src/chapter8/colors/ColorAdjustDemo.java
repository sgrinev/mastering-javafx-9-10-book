/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.colors;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ColorAdjustDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ImageView iv = new ImageView("https://github.com/sgrinev/mastering-javafx-9-book/blob/master/resources/sample.jpg?raw=true");
        iv.setFitHeight(240);
        iv.setFitWidth(240);
        ColorAdjust ca = new ColorAdjust();
        iv.setEffect(ca);

        VBox root = new VBox(10);
        for (DoubleProperty prop : new DoubleProperty[] {
            ca.hueProperty(), ca.contrastProperty(), ca.brightnessProperty(), ca.saturationProperty()
        }) {
            Slider slider = new Slider(-1, 1, 0.);
            prop.bind(slider.valueProperty());
            root.getChildren().add(new HBox(5, slider, new Label(prop.getName())));
        }
        root.getChildren().add(iv);
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

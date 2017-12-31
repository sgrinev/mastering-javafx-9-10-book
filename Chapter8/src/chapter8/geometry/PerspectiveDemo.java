/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.geometry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.StackPane;
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
public class PerspectiveDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        // outer rectangle has a inner shadow
        Rectangle rect = new Rectangle(120, 120);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(4);
        rect.setEffect(new InnerShadow(15, Color.BLACK));

        // text has a drop shadow
        Text text = new Text("FX");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 80));
        text.setEffect(new DropShadow());

        // to apply reflection to both
        // we need to have a common node
        StackPane square = new StackPane(rect, text);
        // this way our StackPane will be small
        // and just wrap the rectangle
        square.setMaxSize(0, 0);

        // aplying transform
        PerspectiveTransform pt = new PerspectiveTransform();
        pt.setUlx(20);
        pt.setUly(20);
        pt.setUrx(100);
        pt.setUry(20);

        pt.setLlx(0);
        pt.setLly(120);
        pt.setLrx(120);
        pt.setLry(120);
        
        square.setEffect(pt);
        square.setOnMouseClicked((e)-> {
            System.out.println("hit");
        });

        StackPane root = new StackPane(square);
        stage.setTitle("Perspective Demo");
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.combining;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
public class EffectsInput extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        final Image image = new Image("https://github.com/sgrinev/mastering-javafx-9-book/blob/master/resources/sample.jpg?raw=true", 200, 200, true, true);
        final Image imageC = new Image("http://www.kidsmathgamesonline.com/images/pictures/patterns/blackwhitecircletarget.jpg", 200, 200, true, true);
        ImageInput ii = new ImageInput(imageC, 0, 0);

        int row = 0;
        for (BlendMode value : BlendMode.values()) {

            Blend blend = new Blend();
            blend.setMode(value);

            blend.setTopInput(ii);
            ImageView iv = new ImageView(image);
            iv.setEffect(blend);

//            Text text = new Text();
//            text.setX(15);
//            text.setY(65);
//            text.setFill(Color.RED);
//            text.setText(value.name());
//            text.setFont(Font.font(null, FontWeight.BOLD, 50));
//            text.setEffect(blend);

            Pane blendEffect = new Pane(iv);
            blendEffect.setMinSize(200, 200);

            Rectangle r = new Rectangle();
            r.setX(90);
            r.setY(50);
            r.setWidth(50);
            r.setHeight(50);
            r.setFill(Color.BLUE);

            Circle c = new Circle();
            c.setFill(Color.rgb(255, 0, 0, 0.5f));
            c.setCenterX(90);
            c.setCenterY(50);
            c.setRadius(25);

            Group blendGroup = new Group();
            blendGroup.setBlendMode(value);
            blendGroup.getChildren().add(r);
            blendGroup.getChildren().add(c);

            root.add(new Label(value.toString()), 0, row);
            root.add(blendEffect, 1, row);
            root.add(blendGroup, 2, row);
            row++;
        }

//        root.setPadding(new Insets(50));
        primaryStage.setTitle("Inputs");
        primaryStage.setScene(new Scene(new ScrollPane(root), 800, 900));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

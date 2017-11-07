/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter5.app;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 */
public class TaskbarDemo extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("FX Demo");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 720, 550, Color.LIGHTGRAY);
        stage.setScene(scene);

        HBox taskbar = new HBox(10);
        taskbar.setPadding(new Insets(10, 30, 50, 30));
        taskbar.setPrefHeight(150);
        taskbar.setAlignment(Pos.CENTER);
        root.setBottom(taskbar);

        for (Color color : new Color[]{Color.RED, Color.BEIGE, Color.BLUEVIOLET, Color.YELLOWGREEN}) {
            taskbar.getChildren().add(createButton(color, () -> System.out.println(color)));
        }

        stage.show();
    }
    private static final double SCALE = 1.3; // коэффициент увеличения

    private static Node createButton(Color fill, final Runnable action) {
        Node node = new Rectangle(50, 50, fill);

        ScaleTransition animationGrow = new ScaleTransition(DURATION, node);
        animationGrow.setToX(SCALE);
        animationGrow.setToY(SCALE);

        ScaleTransition animationShrink = new ScaleTransition(DURATION, node);
        animationShrink.setToX(1);
        animationShrink.setToY(1);

        node.setOnMouseClicked((MouseEvent event) -> {
            action.run();
        });

        node.setOnMouseEntered((MouseEvent event) -> {
            animationGrow.playFromStart();
        });
        animationGrow.setAutoReverse(true);

        node.setOnMouseExited((MouseEvent event) -> {
            animationGrow.stop();
            animationGrow.playFrom(DURATION);
        });

        return node;
    }
    private static final Duration DURATION = Duration.millis(300);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

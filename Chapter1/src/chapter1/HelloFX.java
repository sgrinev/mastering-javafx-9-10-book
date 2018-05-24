/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter1;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class HelloFX extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();

        CheckBox node = new CheckBox("I'm ready for FX!");
        Rectangle rect = new Rectangle(140, 70, Color.LIGHTGRAY);
        root.getChildren().addAll(rect, node);

        Scene scene = new Scene(root, 150, 100);

        stage.setScene(scene);
        stage.setTitle("Hello FX!");
        stage.show();

        traverse(root, 0);
    }

    public static void traverse(Node node, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print(" ");
        }
        System.out.println(node.getClass());
        if (node instanceof Parent) {
            Parent parent = (Parent) node;
            parent.getChildrenUnmodifiable().forEach(n -> traverse(n, level + 1));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

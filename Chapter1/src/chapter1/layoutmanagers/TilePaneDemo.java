/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter1.layoutmanagers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class TilePaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        TilePane root = new TilePane(5, 5);
        root.setPrefColumns(4);
        root.setPrefRows(4);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                double size = 5 + 30 * Math.random();
                Rectangle rect = new Rectangle(size, size, (i + j) % 2 == 0 ? Color.RED : Color.BLUE);
                root.getChildren().add(rect);
            }

        }

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle(root.getClass().getSimpleName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

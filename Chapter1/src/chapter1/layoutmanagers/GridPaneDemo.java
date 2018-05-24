/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter1.layoutmanagers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class GridPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();

        for (int i = 0; i < 5; i++) {
            root.getColumnConstraints().add(new ColumnConstraints(50));
            root.getRowConstraints().add(new RowConstraints(50));
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i + j) % 2 == 0) {
                    root.add(new Rectangle(30, 30, Color.BLUE), i, j);
                }
            }
        }

        Scene scene = new Scene(root, 250, 250);

        primaryStage.setTitle("Hello World!");
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

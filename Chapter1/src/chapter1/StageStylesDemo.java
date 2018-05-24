/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author sgrinev
 */
public class StageStylesDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        root.setStyle("-fx-background-color: #eeeeee;");
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Stage Styles demo");
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.setWidth(1300);
        primaryStage.setHeight(300);
        primaryStage.setScene(scene);
        primaryStage.show();

        int shift = 100;
        for (StageStyle value : StageStyle.values()) {
            Stage stage = new Stage(value);
            stage.setX(shift);
            stage.setY(100);
            shift += 200;
            stage.setTitle(value.name());
            Scene scene2 = new Scene(new StackPane(new Text(value.name())), 150, 100);
            scene2.setFill(Color.TRANSPARENT);
            stage.setScene(scene2);
            stage.show();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

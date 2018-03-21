/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter7.resizing;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class HGrowDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox(10);
        TextField address = new TextField("http://stackoverflow.com");
        HBox.setHgrow(address, Priority.ALWAYS);

        root.getChildren().addAll(
                new Button("Back"), new Button("Home"),
                address, new Button("Go"));

        root.setPadding(new Insets(10));
        root.setAlignment(Pos.TOP_LEFT);
        primaryStage.setTitle("HBox HGrow demo");
        primaryStage.setScene(new Scene(root, 350, 50));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

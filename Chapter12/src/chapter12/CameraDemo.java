/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter12;

import javafx.application.Application;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class CameraDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane(new Button("Hello"));

        Scene scene = new Scene(root, 300, 300);
        scene.setFill(Color.BLACK);
        PerspectiveCamera camera
                = new PerspectiveCamera();
        camera.setTranslateZ(-100);
        camera.setTranslateX(50);
        camera.setTranslateY(50);
        scene.setCamera(camera);
        primaryStage.setTitle("3D JavaFX");
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

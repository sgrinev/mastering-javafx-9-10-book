/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter12;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.Cylinder;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class Basic3dDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        Cylinder cylinder = new Cylinder(40, 120);
        cylinder.setRotationAxis(new Point3D(50, 50, 0));
        cylinder.setRotate(45);
        cylinder.setTranslateX(150);
        cylinder.setTranslateY(150);
        cylinder.setTranslateZ(600);

        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(100);
        camera.setTranslateY(0);
        camera.setTranslateZ(300);

        Group root = new Group(cylinder);
        Scene scene = new Scene(root, 300, 300, true);
        scene.setCamera(camera);

        stage.setScene(scene);
        stage.setTitle("3D shapes demo");
        stage.show();

        scene.setOnMouseMoved((event) -> {
            camera.setTranslateX(event.getSceneX()-50);
            camera.setTranslateY(event.getSceneY()-200);
            camera.setTranslateZ( 300 - event.getSceneX()/2 );
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

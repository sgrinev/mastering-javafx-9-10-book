/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter12;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.shape.Cylinder;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class LightDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        
        Cylinder cylinder = new Cylinder(40, 120);
        cylinder.setRotationAxis(new Point3D(50, 50, 0));
        cylinder.setRotate(45);
        cylinder.setTranslateX(150);
        cylinder.setTranslateY(150);
        cylinder.setTranslateZ(600);
        
        Cylinder cylinder2 = new Cylinder(40, 120);
        cylinder2.setRotationAxis(new Point3D(180, 0, 0));
        cylinder2.setRotate(45);
        cylinder2.setTranslateX(350);
        cylinder2.setTranslateY(150);
        cylinder2.setTranslateZ(600);
        
        PointLight light = new PointLight();
        light.setTranslateX(350);
        light.setTranslateY(100);
        light.setTranslateZ(300);        
        
        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(100);
        camera.setTranslateY(0);
        camera.setTranslateZ(300);

        Group root = new Group(cylinder, cylinder2, light);
        Scene scene = new Scene(root, 300, 300, true);
        scene.setCamera(camera);

        stage.setScene(scene);
        stage.setTitle("Light demo");
        stage.show();

        scene.setOnMouseMoved((event) -> {
            light.setTranslateX(event.getSceneX()-50);
            light.setTranslateY(event.getSceneY()-200);
            light.setTranslateZ( 300 - event.getSceneX()/2 );
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

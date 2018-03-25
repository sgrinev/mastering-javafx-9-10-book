/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter12;

import javafx.application.Application;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class Chapter12 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Sphere sphere = new Sphere(100);
        PhongMaterial material1 = new PhongMaterial();
        material1.setDiffuseColor(Color.BLUE);
        material1.setSpecularColor(Color.LIGHTBLUE);
        material1.setSpecularPower(10.0);
        sphere.setMaterial(material1);
        AmbientLight light = new AmbientLight(Color.AQUA);
        light.setTranslateX(-180);
        light.setTranslateY(-90);
        light.setTranslateZ(-120);
        light.getScope().addAll(sphere);

        PointLight light2 = new PointLight(Color.AQUA);
        light2.setTranslateX(180);
        light2.setTranslateY(190);
        light2.setTranslateZ(180);
        light2.getScope().addAll(sphere);

        Group group = new Group(sphere);

        Scene scene = new Scene(group, 600, 600);
        scene.setFill(Color.BLACK);
        PerspectiveCamera camera
                = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(1000.0);
        camera.setTranslateZ(-1000);
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

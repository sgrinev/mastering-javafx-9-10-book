/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter12;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 */
public class EarthDemo extends Application {

    @Override
    public void start(Stage stage) {
        Sphere sphere = new Sphere(150);
        sphere.setTranslateX(450);
        sphere.setTranslateY(300);
        sphere.setTranslateZ(400);
        sphere.setRotationAxis(new Point3D(1, 1, 0));

        PhongMaterial mat = new PhongMaterial();
        Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Reversed_Earth_map_1000x500.jpg/800px-Reversed_Earth_map_1000x500.jpg");
        mat.setSelfIlluminationMap(image);
        sphere.setMaterial(mat);

        PointLight light = new PointLight(Color.LIGHTYELLOW);
        light.setTranslateX(350);
        light.setTranslateY(100);
        light.setTranslateZ(300);

        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(300);
        camera.setTranslateY(150);
        camera.setTranslateZ(300);

        Scene scene = new Scene(new Group(sphere, light), 300, 300, true);
        scene.setCamera(camera);

        stage.setScene(scene);
        stage.setTitle("3D shapes demo");
        stage.show();

        RotateTransition rot = new RotateTransition(Duration.seconds(10), sphere);
        rot.setToAngle(360);
        rot.setInterpolator(Interpolator.LINEAR);
        rot.setCycleCount(Timeline.INDEFINITE);
        rot.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

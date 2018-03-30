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
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class MaterialBumpMapDemo extends Application {

    @Override
    public void start(Stage stage) {
        PhongMaterial material = new PhongMaterial();
        material.setBumpMap(new Image("https://upload.wikimedia.org/wikipedia/commons/8/86/IntP_Brick_NormalMap.png"));

        Box box = new Box(100, 100, 100);
        box.setTranslateX(250);
        box.setTranslateY(100);
        box.setTranslateZ(400);
        box.setRotate(50);
        box.setRotationAxis(new Point3D(100, 100, 0));
        box.setMaterial(material);

        PointLight light = new PointLight();
        light.setTranslateX(50);
        light.setTranslateY(150);
        light.setTranslateZ(300);

        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(100);
        camera.setTranslateY(-50);
        camera.setTranslateZ(300);
        
        Group root = new Group(box, light);
        Scene scene = new Scene(root, 300, 300, true);
        scene.setCamera(camera);

        stage.setScene(scene);
        stage.setTitle("Bump Map material demo");
        stage.show();
        
        scene.setOnMouseMoved((event) -> {
            light.setTranslateX(event.getSceneX()-50);
            light.setTranslateY(event.getSceneY()-200);
            light.setTranslateZ( 300 - event.getSceneX()/2 );
        });        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

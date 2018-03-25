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
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class Figures extends Application {

    @Override
    public void start(Stage stage) {

//https://www.publicdomainpictures.net/pictures/220000/velka/free-fantasy-map.jpg

         PhongMaterial fmat = new PhongMaterial();
//        mat.setDiffuseMap(diffuseMap);
        fmat.setBumpMap(new Image("https://upload.wikimedia.org/wikipedia/commons/8/86/IntP_Brick_NormalMap.png"));
        
// Create a Box
        Box box = new Box(100, 100, 100);
        box.setTranslateX(150);
        box.setTranslateY(200);
        box.setTranslateZ(400);
        box.setMaterial(fmat);

        // Create a Sphere
        Sphere sphere = new Sphere(70);
        sphere.setTranslateX(300);
        sphere.setTranslateY(150);
        sphere.setTranslateZ(400);
        
        PhongMaterial mat = new PhongMaterial();
        Image diffuseMap = new Image("http://www.futuretech.blinkenlights.nl/n64images/smallGlobe.jpg");
        //http://www.futuretech.blinkenlights.nl/n64images/smallGlobe.jpg
        mat.setDiffuseMap(diffuseMap);
//        mat.setBumpMap(diffuseMap);
        sphere.setMaterial(mat);

        // Create a Cylinder
        Cylinder cylinder = new Cylinder(40, 120);
        cylinder.setRotationAxis(new Point3D(50, 50, 0));
        cylinder.setRotate(45);
        cylinder.setTranslateX(450);
        cylinder.setTranslateY(120);
        cylinder.setTranslateZ(600);

        // Create a Light
        PointLight light = new PointLight();
        light.setTranslateX(350);
        light.setTranslateY(100);
        light.setTranslateZ(300);

        // Create a Camera to view the 3D Shapes
        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(100);
        camera.setTranslateY(-50);
        camera.setTranslateZ(300);
        
        
        Group root = new Group(box, sphere, cylinder, light);

        Scene scene = new Scene(root, 400, 400, true);
        scene.setCamera(camera);

        stage.setScene(scene);
        stage.setTitle("3D shapes demo");
        stage.show();
        
//        TranslateTransition tt = new TranslateTransition(Duration.seconds(5), camera);
//        tt.setAutoReverse(true);
//        tt.setFromX(0);
//        tt.setToX(300);
//        tt.setCycleCount(Timeline.INDEFINITE);
//        tt.play();
        
        scene.setOnMouseMoved((event) -> {
            System.out.println(event.getSceneX() + " " + event.getSceneY());
            camera.setTranslateX(event.getSceneX());
            camera.setTranslateY(event.getSceneY() - 100 );
        });
        
        stage.setX (2000);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

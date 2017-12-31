/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.geometry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.FloatMap;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class DisplacementMapDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        final int SIDE = 240;
        ImageView iv = new ImageView("https://github.com/sgrinev/mastering-javafx-9-book/blob/master/Chapter8/src/chapter8/colors/sample.jpg?raw=true");
        iv.setFitHeight(SIDE);
        iv.setFitWidth(SIDE);

        FloatMap floatMap = new FloatMap();
        floatMap.setWidth(SIDE);
        floatMap.setHeight(SIDE);

        for (int i = 0; i < SIDE; i++) {
            double v = (Math.sin(i / 20.0 * Math.PI) - 0.5) / 40.0;
            System.out.println(i + ": " + v);
            for (int j = 0; j < SIDE; j++) {
                floatMap.setSamples(i, j, 0.0f, (float)v);
            }
        }

        DisplacementMap displacementMap = new DisplacementMap();
        displacementMap.setMapData(floatMap);
        iv.setEffect(displacementMap);

        primaryStage.setTitle("DisplacementMap Demo");
        primaryStage.setScene(new Scene(new StackPane(iv), 300, 300));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

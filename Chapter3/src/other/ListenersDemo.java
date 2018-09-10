/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package other;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ListenersDemo extends Application {
    
    int cl = 0;
    int il = 0;

    @Override
    public void start(Stage stage) {
        Label lblWidth = new Label();
        Scene scene =new Scene(new StackPane(lblWidth), 200, 150);

        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                cl++;
                //System.out.println(cl + " " + il);
            }
        });
        
        scene.heightProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                il++;
                System.out.println(cl + " " + il);
            }
        });

        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

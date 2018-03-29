/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter7.resizing;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class MinMaxSizeDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btnNoMin = new Button("I have no min width");
        Button btnMin = new Button("I have min width");
        btnMin.setMinWidth(100);
        Button btnMax = new Button("I have limited max width");
        btnMax.setMaxWidth(140);
        Button btnBig = new Button("I have large max width");
        btnBig.setMaxWidth(1000);
        Button btnBig2 = new Button("me too");
        btnBig2.setMaxWidth(1000);
        
        
        VBox root = new VBox(5);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(btnNoMin, btnMin, btnMax, btnBig, btnBig2);
        
        Scene scene = new Scene(root, 300, 200);
        
        primaryStage.setTitle("sizes");
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

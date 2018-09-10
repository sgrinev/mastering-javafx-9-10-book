/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter6.basics;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class FirstStyles extends Application {
    
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 300, 250);


        Button btnLoad = new Button("Load CSS");
        btnLoad.setOnAction((ActionEvent event) -> {
//            scene.getStylesheets().add("/chapter6/basics/style.css");
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//            scene.getStylesheets().add("https://raw.githubusercontent.com/sgrinev/mastering-javafx-9-10-book/master/Chapter6/src/chapter6/basics/style.css");
        });
        
        Button btnUnload = new Button("Unload CSS");
        btnUnload.setOnAction((ActionEvent event) -> {
            scene.getStylesheets().clear();
        });
        
        root.getChildren().addAll(btnLoad, btnUnload);
        stage.setTitle("Hello CSS!");
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

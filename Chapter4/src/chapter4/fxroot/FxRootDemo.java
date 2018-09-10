/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter4.fxroot;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class FxRootDemo extends Application {
    
    @Override
    public void start(Stage stage) throws IOException  {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(new MyControl("Hello, World"));
        Scene scene = new Scene(stackPane, 300, 80);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * (C) Packt Publishing Ltd, 2017-2018
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

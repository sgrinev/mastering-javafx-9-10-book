/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter4.first;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class DemoFXML extends Application {
    
    @Override
    public void start(Stage stage) throws IOException  {
        HBox root = FXMLLoader.<HBox>load(getClass().getResource("FirstDocument.fxml"));
        System.out.println(getClass().getResource("FirstDocument.fxml"));
        Scene scene = new Scene(root, 300, 80);
        
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

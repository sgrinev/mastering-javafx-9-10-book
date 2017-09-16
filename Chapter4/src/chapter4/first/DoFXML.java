/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter4.first;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class DoFXML extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        HBox root = FXMLLoader.<HBox>load(getClass().getResource("FirstDocument.fxml"));
        HBox root = (HBox) FXMLLoader.load(getClass().getResource("FirstDocument.fxml"));
        System.out.println(getClass().getResource("FirstDocument.fxml"));
        //jar:file:/C:/work/mastering-javafx-9-book/Chapter4/dist/run588027943/Chapter4.jar!/chapter4/first/FirstDocument.fxml
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

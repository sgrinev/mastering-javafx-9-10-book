/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapterEleven;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author sgrinev
 */
public class SimpleApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Open Second Window");
        btn.setOnAction((ActionEvent event) -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("SecondStage.fxml"));
                Stage secondStage = new Stage(StageStyle.UTILITY);
                secondStage.setScene(new Scene(root));
                secondStage.show();
            } catch (IOException ex) {
                System.out.println("Failed to load FXML");
                ex.printStackTrace();
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 200, 200);
        
        primaryStage.setTitle("SimpleApp");
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

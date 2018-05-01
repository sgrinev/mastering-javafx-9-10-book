package chapter1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class StageFullScreen extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setFullScreenExitHint("Exit code is Ctrl+B");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("Ctrl+B"));
        primaryStage.setFullScreen(true);
        primaryStage.show();
        KeyCodeCombination kc = new KeyCodeCombination(KeyCode.B, KeyCombination.CONTROL_DOWN);
//        System.out.println(kc.getName());
////        primaryStage.setFullScreenExitKeyCombination(kc);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

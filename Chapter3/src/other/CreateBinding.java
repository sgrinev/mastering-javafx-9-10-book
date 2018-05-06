/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package other;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class CreateBinding extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Click me");

        StackPane root = new StackPane();
        root.setBackground(Background.EMPTY);
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);

//      Option 1. Extending abstract class
//      ObjectBinding<Paint> objectBinding = 
//            new ObjectBinding<Paint>() {
//                {
//                    bind(btn.pressedProperty());
//                }
//                @Override
//                protected Paint computeValue() {
//                    return btn.isPressed() ? Color.RED : Color.GREEN;
//                }
//            };
        
//      Option 2. Using Bindings helper method
        ObjectBinding<Paint> objectBinding = Bindings.createObjectBinding(
                ()-> btn.isPressed() ? Color.MAGENTA : Color.AQUA, 
                btn.pressedProperty());

//        scene.fillProperty().bind(objectBinding);

//      Option 3. Using bindings operations
        scene.fillProperty().bind(Bindings.when(btn.pressedProperty()).then(Color.YELLOW).otherwise(Color.STEELBLUE));
        
        
        

        primaryStage.setTitle("Binding helper");
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

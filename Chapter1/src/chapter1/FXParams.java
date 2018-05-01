package chapter1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class FXParams extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        System.out.println("Raw:");
        getParameters().getRaw().forEach(System.out::println);

        System.out.println("Unnamed:");
        getParameters().getUnnamed().forEach(System.out::println);

        System.out.println("Named:");
        getParameters().getNamed().forEach((p, v) -> { System.out.println(p + "=" +v);});
        
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class FXParams extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        System.out.println("== Raw ==");
        getParameters().getRaw().forEach(System.out::println);

        System.out.println("== Unnamed ==");
        getParameters().getUnnamed().forEach(System.out::println);

        System.out.println("== Named ==");
        getParameters().getNamed().forEach((p, v) -> { System.out.println(p + "=" +v);});
        
        // we don't need to do any UI for this demo and just exit
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

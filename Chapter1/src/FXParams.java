/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
import javafx.application.Application;
import javafx.application.Platform;
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

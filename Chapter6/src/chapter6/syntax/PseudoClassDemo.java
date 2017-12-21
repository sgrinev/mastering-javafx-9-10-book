/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter6.syntax;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class PseudoClassDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        ToggleGroup group = new ToggleGroup();
        for (String title : new String[] {"Cats", "Dogs", "Birds", "Mices"}) {
            RadioButton rb = new RadioButton(title);
            rb.setToggleGroup(group);
            root.getChildren().add(rb);
        }
        
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("pseudo-class-demo.css").toExternalForm());
        stage.setTitle("PseudoClass Demo");
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

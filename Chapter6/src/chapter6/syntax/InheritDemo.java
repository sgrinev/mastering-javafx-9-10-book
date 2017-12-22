/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter6.syntax;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class InheritDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        ToggleGroup group = new ToggleGroup();
        for (String title : new String[] {"red", "yellow", "green", "lightgray"}) {
            RadioButton rb = new RadioButton(title);
            rb.setToggleGroup(group);
            root.getChildren().add(rb);
        }
        group.selectedToggleProperty().addListener((observable) -> {
            if (group.getSelectedToggle() != null) {
                RadioButton selected = (RadioButton)group.getSelectedToggle();
                root.setStyle("-fx-background-color: " + selected.getText());
            }
        });
        
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("inherit-demo.css").toExternalForm());
        stage.setTitle("Inherit Demo");
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

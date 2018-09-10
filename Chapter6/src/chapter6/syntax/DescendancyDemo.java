/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter6.syntax;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class DescendancyDemo extends Application {

    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox(10);
        vbox.setId("vb");
        ToggleGroup group = new ToggleGroup();
        for (String title : new String[]{"Cats", "Dogs", "Birds", "Mices"}) {
            RadioButton rb = new RadioButton(title);
            rb.setToggleGroup(group);
            vbox.getChildren().add(rb);
        }

        RadioButton rbDescendant = new RadioButton("outside");
        rbDescendant.setToggleGroup(group);

        RadioButton rbDeepDescendant = new RadioButton("not direct child");
        rbDeepDescendant.setToggleGroup(group);
        // below we are adding a StackPane to make rbDeepDescendant not a direct child of VBox
        vbox.getChildren().add(new StackPane(rbDeepDescendant));

        VBox hbox = new VBox(10);
        hbox.getChildren().addAll(vbox, rbDescendant);
        Scene scene = new Scene(hbox, 300, 250);
        scene.getStylesheets().add(getClass().getResource("selectors-demo.css").toExternalForm());
        stage.setTitle("Descendancy Demo");
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

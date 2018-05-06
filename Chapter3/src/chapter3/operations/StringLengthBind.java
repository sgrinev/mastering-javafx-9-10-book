/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter3.operations;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class StringLengthBind extends Application {

    @Override
    public void start(Stage stage) {
        TextField textField = new TextField();
        Label lblLength = new Label();
/*
        lblLength.textProperty().bind(
                textField.textProperty()
                    .length()   // this length returns IntegerBinding, not just an integer
                    .asString() // so you can keep observing it and use binding methods
        );
*/        
        lblLength.textProperty().bind(
            Bindings.concat("Count: ", textField.textProperty().length()));

        HBox root = new HBox(20, textField, lblLength);
        root.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(root, 250, 100));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

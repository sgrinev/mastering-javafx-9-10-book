/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter3.operations;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ConcatBinding extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label();

        label.textProperty().bind(
                stage.widthProperty().asString()  // property one
                .concat(" : ")                    // concatting with a string constant
                .concat(stage.heightProperty())   // concatting with a property 2
         );
        
        label.textProperty().unbind();
        label.textProperty().bind(
//            Bindings.concat(stage.widthProperty(), " : ", stage.heightProperty())
            Bindings.format("Window size is %1$.0fx%2$.0f", stage.widthProperty(), stage.heightProperty())
        );

        stage.setScene(new Scene(new StackPane(label), 200, 150));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

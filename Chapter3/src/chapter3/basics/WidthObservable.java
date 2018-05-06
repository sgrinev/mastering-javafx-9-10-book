/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter3.basics;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class WidthObservable extends Application {

    @Override
    public void start(Stage stage) {
        Label lblWidth = new Label();

        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                lblWidth.setText(newValue.toString());
            }
        });

        stage.setScene(new Scene(new StackPane(lblWidth), 200, 150));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

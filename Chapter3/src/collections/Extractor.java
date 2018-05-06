/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package collections;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class Extractor extends Application {
    
    @Override
    public void start(Stage stage) {
        // Lets have a list of Buttons
        List<Button> buttons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buttons.add(new Button(i + ""));
        }

        // Now lets have an observable collection which
        // will trigger listener when any button is pressed:
        ObservableList<Button> observableList = FXCollections.observableList(buttons, (btn) -> {
            // in the extractor we need to return
            // a list of observables to be tracked
            return new Observable[] { btn.pressedProperty() }; 
        });

        // And add a listener
        IntegerProperty counter = new SimpleIntegerProperty(0);
        observableList.addListener((ListChangeListener.Change<? extends Button> c) -> {
            counter.set(counter.intValue() + 1);
        });

        Label label = new Label();
        label.textProperty().bind(counter.asString("changes count: %1$s"));

        HBox root = new HBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(label);
        root.getChildren().addAll(buttons);
        stage.setScene(new Scene(root, 500, 100));
        stage.setTitle("Binding to a List demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

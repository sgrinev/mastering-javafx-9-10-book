/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter10.list;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class MultiselectDemo extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<String> items = FXCollections.observableArrayList(
                "Red", "Blue", "Yellow", "Green",
                "Magenta", "Pink", "Cyan", "Gray");
        ListView<String> list = new ListView<>(items);
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        list.getSelectionModel().selectedIndexProperty().addListener((obs) -> {
            System.out.println("Selected: " + list.getSelectionModel().getSelectedItems());
            System.out.println("Focused: " + list.getFocusModel().getFocusedItem());
        });

        stage.setTitle("List");
        stage.setScene(new Scene(new StackPane(list), 200, 350));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

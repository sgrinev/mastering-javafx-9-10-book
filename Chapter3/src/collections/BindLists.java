/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package collections;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class BindLists extends Application {
    
    @Override
    public void start(Stage stage) {
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("1", "2", "abc");
        
        ListView<String> listView2 = new ListView<>();
        listView2.itemsProperty().bind(listView.itemsProperty());

        Button button = new Button("add");
        button.setOnAction((e)->listView.getItems().add("Item " + listView.getItems().size()));

        BorderPane root = new BorderPane();
        root.setLeft(listView);
        root.setRight(listView2);
        root.setBottom(button);
        
        stage.setScene(new Scene(root, 500, 250));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

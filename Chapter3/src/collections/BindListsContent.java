/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package collections;

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class BindListsContent extends Application {
    
    @Override
    public void start(Stage stage) {
        ListView<StringContainer> listView = new ListView<>();
        StringContainer sc = new StringContainer("1");
        listView.getItems().addAll(sc, new StringContainer("22"), new StringContainer("bob"));
        
        ListView<StringContainer> listView2 = new ListView<>();
        listView2.itemsProperty().bind(listView.itemsProperty());

        BorderPane root = new BorderPane();
        root.setLeft(listView);
        root.setRight(listView2);
        
        Button button = new Button("add");
        button.setOnAction((e)->listView.getItems().add(new StringContainer("Item " + listView.getItems().size())));
        root.setBottom(button);
        
        Scene scene = new Scene(root, 500, 250);
        
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
        listView.getItems().add(new StringContainer("new"));
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private static class StringContainer {
        StringProperty content = new SimpleStringProperty();

        public StringContainer(String txt) {
            content.setValue(txt);
        }

        @Override
        public String toString() {
            return content.getValue();
        }
    }
}

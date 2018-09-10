/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter10.list;

import java.util.Random;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class ListViewDemo extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<String> items = FXCollections.observableArrayList(
                "Red", "Blue", "Yellow", "Green");
        ListView<String> list = new ListView<>(items);

        Button btn = new Button("Add New Item");
        btn.setOnAction((e) -> {
            items.add(
                    // just a way to generate semirandom new items
                    items.get(new Random().nextInt(items.size()))
            );
        });

        VBox root = new VBox(5);
        root.setPadding(new Insets(7));
        root.getChildren().addAll(list, btn);
        stage.setTitle("List");
        stage.setScene(new Scene(root, 200, 350));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

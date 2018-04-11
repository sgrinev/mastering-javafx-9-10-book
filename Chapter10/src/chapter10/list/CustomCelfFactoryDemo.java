/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter10.list;

import java.util.Random;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class CustomCelfFactoryDemo extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<String> items = FXCollections.observableArrayList(
                "Red", "Blue", "Yellow", "Green");
        ListView<String> list = new ListView<>(items);

        list.setCellFactory((ListView<String> param) -> {
            return new ListCell<String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!(empty || item == null)) {
                        setGraphic(new Rectangle(30, 30, Color.web(item)));
                        setText(item);
                    } else {
                        setText(null);
                        setGraphic(null);
                    }
                }
            };
        });

        Button btn = new Button("Add New Item");
        btn.setOnAction((e) -> {
            items.add(
                    // just a way to generate semirandom new items
                    items.get(new Random().nextInt(items.size()))
            );
            System.out.println(items.size());
        });

        VBox root = new VBox(5);
        root.setPadding(new Insets(7));
        root.getChildren().addAll(list, btn);
        stage.setTitle("Custom List Cell");
        stage.setScene(new Scene(root, 200, 250));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

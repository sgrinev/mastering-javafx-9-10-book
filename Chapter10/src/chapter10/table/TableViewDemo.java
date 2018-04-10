/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter10.table;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class TableViewDemo extends Application {

    private TableView<Chapter> table = new TableView<Chapter>();
    private final ObservableList<Chapter> listChapters
            = FXCollections.observableArrayList(
                    new Chapter(1, "Stages, Scenes and Layout"),
                    new Chapter(2, "Building Blocks: Shapes, Text and Controls"),
                    new Chapter(3, "Connecting Pieces: Binding"),
                    new Chapter(4, "FXML"),
                    new Chapter(5, "Animation"),
                    new Chapter(6, "Styling application with CSS"),
                    new Chapter(7, "Building Dynamic UI"),
                    new Chapter(8, "Effects"),
                    new Chapter(9, "Media and WebView"),
                    new Chapter(10, "Advanced Controls and Charts "),
                    new Chapter(11, "Packaging with Java9 Jigsaw"),
                    new Chapter(12, "3D at a glance"),
                    new Chapter(13, "What next?")
            );

    public static void main(String args[]) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Mastering JavaFX");
        FlowPane root = new FlowPane();

        table.setEditable(true);

        TableColumn<Chapter, String> columnTitle = new TableColumn<>("Title");
        columnTitle.setCellValueFactory(
                new PropertyValueFactory<>("title"));

        TableColumn<Chapter, Integer> columnNumber = new TableColumn<>("#");
        columnNumber.setCellValueFactory(
                new PropertyValueFactory<>("number"));

        table.setItems(listChapters);
        table.getColumns().addAll(columnNumber, columnTitle);

        root.getChildren().addAll(table);
        stage.setScene(new Scene(root, 300, 400));
        stage.show();
    }

}

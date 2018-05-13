/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter10.table;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class EditableTableViewDemo extends Application {

    private final ObservableList<ObservableChapter> listChapters
            = FXCollections.observableArrayList(new ObservableChapter(1, "Stages, Scenes and Layout"),
                    new ObservableChapter(2, "Building Blocks: Shapes, Text and Controls"),
                    new ObservableChapter(3, "Connecting Pieces: Binding"),
                    new ObservableChapter(4, "FXML"),
                    new ObservableChapter(5, "Animation"),
                    new ObservableChapter(6, "Styling application with CSS"),
                    new ObservableChapter(7, "Building Dynamic UI"),
                    new ObservableChapter(8, "Effects"),
                    new ObservableChapter(9, "Media and WebView"),
                    new ObservableChapter(10, "Advanced Controls and Charts "),
                    new ObservableChapter(11, "Packaging with Java9 Jigsaw"),
                    new ObservableChapter(12, "3D at a glance"),
                    new ObservableChapter(13, "What's next?")
            );

    public static void main(String args[]) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Editable Table");
        TableColumn<ObservableChapter, String> columnTitle = new TableColumn<>("Title");

        columnTitle.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTitle.setOnEditCommit((CellEditEvent<ObservableChapter, String> t) -> {
            t.getRowValue().setTitle(t.getNewValue());
            // debug output
            listChapters.stream().forEach(System.out::println);
        });

        columnTitle.setCellValueFactory(
                new PropertyValueFactory<>("title"));

        TableColumn<ObservableChapter, Integer> columnNumber = new TableColumn<>("#");
        columnNumber.setCellValueFactory(
                new PropertyValueFactory<>("number"));

        TableView<ObservableChapter> table = new TableView<>();
        table.setEditable(true);
        table.setItems(listChapters);
        table.getColumns().add(columnNumber);
        table.getColumns().add(columnTitle);

        stage.setScene(new Scene(table, 330, 400));
        stage.show();
    }

}

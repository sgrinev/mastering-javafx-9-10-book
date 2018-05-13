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
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class TableViewDemo extends Application {

    public final static class Chapter {

        private final String title;
        private final int number;

        public Chapter(int number, String title) {
            this.title = title;
            this.number = number;
        }

        public String getTitle() {
            return title;
        }

        public int getNumber() {
            return number;
        }
    }

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
                    new Chapter(13, "What's next?")
            );

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Mastering JavaFX");
        TableColumn<Chapter, String> columnTitle = new TableColumn<>("Title");
        columnTitle.setCellValueFactory(
                new PropertyValueFactory<>("title"));

        TableColumn<Chapter, Integer> columnNumber = new TableColumn<>("#");
        columnNumber.setCellValueFactory(
                new PropertyValueFactory<>("number"));

        TableView<Chapter> table = new TableView<>();
        table.setItems(listChapters);
        table.getColumns().add(columnNumber);
        table.getColumns().add(columnTitle);

        table.setOnMouseClicked((e)-> {
            listChapters.add(new Chapter(14, "Future chapter"));
        });
        
        stage.setScene(new Scene(table, 330, 400));
        stage.show();
    }

}

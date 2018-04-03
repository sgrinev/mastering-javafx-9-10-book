/*
 * (C) Packt Publishing Ltd), new TodoItem(2017-2018
 */
package chapter10.list;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 *
 * @author sgrinev
 */
public class CheckBoxDemo extends Application {

    private static final class TodoItem {

        final String name;
        final BooleanProperty isDone = new SimpleBooleanProperty(false);

        public TodoItem(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name + (isDone.get() ? " DONE" : "");
        }
    }

    @Override
    public void start(Stage stage) {

        ObservableList<TodoItem> items = FXCollections.observableArrayList(
                (TodoItem item) -> new Observable[]{item.isDone});
        items.addAll(
                new TodoItem("Sign a Contract"), new TodoItem("Fail Deadline"),
                new TodoItem("Blame Yourself"), new TodoItem("Suffer"));

        ListView<TodoItem> list = new ListView<>(items);
        list.setEditable(true);
        list.setCellFactory(CheckBoxListCell.forListView(item -> item.isDone, new StringConverter<TodoItem>() {
            @Override
            public String toString(TodoItem item) {
                return item.name;
            }

            @Override
            public TodoItem fromString(String string) {
                throw new UnsupportedOperationException("We don't need this.");
            }
        }));

        items.addListener((ListChangeListener.Change<? extends TodoItem> change) -> {
            items.stream().forEach(System.out::println);
        });

        stage.setTitle("TodoList Demo");
        stage.setScene(new Scene(new StackPane(list), 200, 200));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

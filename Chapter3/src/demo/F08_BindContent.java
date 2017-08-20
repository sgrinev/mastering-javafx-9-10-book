/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class F08_BindContent extends Application {
    // a great example can be found here: https://stackoverflow.com/a/28285675/1054140
    
    @Override
    public void start(Stage stage) {
        ListView<StringContainer> listView = new ListView<>();
        StringContainer sc = new StringContainer("1");
        listView.getItems().addAll(sc, new StringContainer("22"), new StringContainer("bob"));
        
        ObservableList<StringContainer> observableArrayList = FXCollections.<StringContainer>observableArrayList((param) ->  new Observable[] {param.content});
        Bindings.bindContent(observableArrayList, listView.getItems());

        ListView<StringContainer> listView2 = new ListView<>(observableArrayList);
//        listView2.itemsProperty().bind
        HBox root = new HBox();
        root.getChildren().addAll(listView, listView2);
        
        Scene scene = new Scene(root, 300, 250);
        
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
        listView.getItems().add(new StringContainer("new"));
        Platform.runLater(()-> sc.content.set("-1"));
    }

    /**
     * @param args the command line arguments
     */
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

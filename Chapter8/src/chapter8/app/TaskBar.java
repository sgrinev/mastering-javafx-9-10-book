/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter8.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class TaskBar extends Application {
    
    public static void main(String[] args) {
        // это наша точка старта -- этот метод поднимает FX стек и загружает туда наше приложение
        Application.launch(args);
    }

    private HBox taskbar;

    @Override
    public void start(Stage stage) {
       
        // переданный в параметре объект stage является нашим окном
        stage.setTitle("FX Demo");

        // здесь мы создаём сцену, которая является содержимым окна и layout manager для неё
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 720, 550, Color.LIGHTGRAY);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // создадим отдельный layout для иконок-кнопок -- horizontal box
        taskbar = new HBox(10);
        taskbar.setPadding(new Insets(10, 30, 50, 30));
        taskbar.setPrefHeight(150);
        taskbar.setAlignment(Pos.CENTER);
        root.setBottom(taskbar);

        // и добавим сами кнопки из подготовленных картинок
        for (int i = 0; i < 5; i++) {
            StackPane node = new StackPane();
//Rectangle node = new Rectangle(50, 50);
            Text text = new Text("" + i);
            node.getChildren().add(text);
            node.getStyleClass().add("square-button");
            node.setMinSize(50, 50);
            node.setEffect(new Reflection());
            //node.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.NONE, CornerRadii.EMPTY, new BorderWidths(1))));
            taskbar.getChildren().add(node);
        }
        stage.show();
    }
}
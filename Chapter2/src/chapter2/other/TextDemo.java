/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter2.other;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class TextDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text txt = new Text("Hello\nJavaFX!");
        txt.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.ITALIC, 30));

        Stop[] stops = new Stop[]{new Stop(0, Color.BLACK), new Stop(1, Color.DARKGRAY), new Stop(0.5, Color.ANTIQUEWHITE)};
        LinearGradient gradient = new LinearGradient(50, 50, 250, 50, false, CycleMethod.NO_CYCLE, stops);
        txt.setFill(gradient);

        Text txt1 = new Text("Text1");
        txt1.setFont(Font.font("Courier New", 15));
        Text txt2 = new Text("Text2");
        txt2.setFont(Font.font("Times New Roman", 20));
        Text txt3 = new Text("Text3");
        txt3.setFont(Font.font("Arial", 30));
        TextFlow textFlow = new TextFlow(txt1, txt2, txt3);

        VBox root = new VBox(30, txt, textFlow);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

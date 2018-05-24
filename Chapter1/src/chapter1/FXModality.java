/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter1;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXModality extends Application {

    @Override
    public void start(Stage stage1) {
        // here we create a regular window
        Scene scene = new Scene(new Group(), 300, 250);
        stage1.setTitle("Main Window");
        stage1.setScene(scene);
        stage1.show();

        // this window doesn't block mouse and keyboard events
        Stage stage2 = new Stage();
        stage2.setTitle("I don't block anything");
        stage2.initModality(Modality.NONE);
        stage2.show();

        // this window blocks everything - you can't interact 
        // with other windows while it's open
        Stage stage3 = new Stage();
        stage3.setTitle("I block everything");
        stage3.initModality(Modality.APPLICATION_MODAL);
        stage3.show();

        // this window blocks only interaction with main app window (stage1)
        Stage stage4 = new Stage();
        stage4.setTitle("I block only clicks to main window");
        stage4.initOwner(stage1);
        stage4.initModality(Modality.WINDOW_MODAL);
        stage4.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

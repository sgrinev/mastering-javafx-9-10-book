/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter4.fxroot;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author sgrinev
 */
public class MyControl extends HBox {
    
    @FXML
    private TextField textField;

    @FXML
    private Label label;

    public MyControl(String text) throws IOException {
        setAlignment(Pos.CENTER);
        setSpacing(5);
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyControl.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        fxmlLoader.load();
        
        textField.setText(text);
        label.setText("Message: ");
    }
}

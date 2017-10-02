/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter4.fxroot;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author sgrinev
 */
public class MyController implements Initializable {
    
    @FXML
    private TextField textField;

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textField.setText("hi");
    }
}

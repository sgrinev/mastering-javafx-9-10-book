/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
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

/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter4.includes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author sgrinev
 */
public class FirstController implements Initializable {
    
    @FXML
    private NestedController myLabelController;
    
    @FXML
    void btnAction(ActionEvent event) {
        myLabelController.setButtonText(textField.getText());
    }   
    
    @FXML
    private TextField textField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}

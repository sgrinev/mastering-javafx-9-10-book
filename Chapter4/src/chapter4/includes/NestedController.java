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
import javafx.scene.control.Button;

/**
 *
 * @author sgrinev
 */
public class NestedController implements Initializable {
    
    @FXML
    private Button myBtn;
    
    @FXML
    void myBtnAction(ActionEvent event) {
        System.out.println("Hello from " + myBtn.getText());
    }    
    
    public void setButtonText(String text) {
        myBtn.setText(text);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}

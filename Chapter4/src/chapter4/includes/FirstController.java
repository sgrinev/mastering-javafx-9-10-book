/*
 * (C) Packt Publishing Ltd, 2017-2018
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

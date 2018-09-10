/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter7.resizing.browser;

/**
 *
 * @author sgrinev
 */
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class Controller {

    @FXML
    void btnGoAction(ActionEvent event) {
        status.setText("Loading " + address.getText());
        webView.getEngine().load(address.getText());
    }

    @FXML
    void btnBackAction(ActionEvent event) {
        webView.getEngine().getHistory().go(-1);
    }

    @FXML
    private TextField address;

    @FXML
    private WebView webView;

    @FXML
    private Label status;

    @FXML
    void initialize() {
        webView.getEngine().getLoadWorker().stateProperty().addListener(
                (o, oldValue, newValue) -> {
                    if (newValue == Worker.State.SUCCEEDED) {
                        status.setText(address.getText() + " has been loaded.");
                        address.setText(webView.getEngine().getLocation());
                    }
                    if (newValue == Worker.State.FAILED) {
                        status.setText("Failed to load " + address.getText());
                    }
                });
        btnGoAction(null);
    }
}

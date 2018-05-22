/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter10.skins;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.binding.Bindings;
import javafx.scene.Node;
import javafx.scene.control.Skin;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author sgrinev
 */
public class ClockSkinText implements Skin<ClockControl> {

    private final ClockControl control;
    private final StackPane root;
    private final Text txtTime = new Text();

    // skin creation
    public ClockSkinText(ClockControl control) {
        this.control = control;
        Rectangle border = new Rectangle(120, 50, Color.TRANSPARENT);
        border.setStroke(Color.BLACK);
        root = new StackPane(txtTime, border);
        txtTime.setFont(FONT);
        // connecting text clock with our model value
        txtTime.textProperty().bind(
                Bindings.createStringBinding(() -> {
                    Date date = control.timeProp.get();
                    return date == null ? "" : FORMAT.format(date);
                }, control.timeProp)
        );
    }

    // this Skin method returns the control we are "skinning"
    @Override
    public ClockControl getSkinnable() {
        return control;
    }

    // this Skin method returns root node of our skin
    @Override
    public Node getNode() {
        return root;
    }

    // this method can be used to clean any used resources
    @Override
    public void dispose() {
        // we have nothing to clean up
    }

    // constants
    private static final Font FONT = Font.font ("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 20);
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("hh:mm:ss");
}

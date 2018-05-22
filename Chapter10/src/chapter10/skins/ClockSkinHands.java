/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter10.skins;

import javafx.scene.Node;
import javafx.scene.control.Skin;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

/**
 *
 * @author sgrinev
 */
public class ClockSkinHands implements Skin<ClockControl> {

    private final ClockControl control;
    private final Pane root;
    private final Rotate rotateSecondHand = new Rotate(0, 0, 0);
    private final Rotate rotateMinuteHand = new Rotate(0, 0, 0);
    private final Rotate rotateHourHand = new Rotate(0, 0, 0);
    
    public ClockSkinHands(ClockControl control) {
        this.control = control;
        // create minutes hand
        Path minuteHand = new Path(
                new MoveTo(0, 0),
                new LineTo(15, -5),
                new LineTo(100, 0),
                new LineTo(15, 5),
                new ClosePath());
        minuteHand.setFill(Color.DARKGRAY);
        minuteHand.getTransforms().add(rotateMinuteHand);
        minuteHand.setTranslateX(minuteHand.getBoundsInLocal().getWidth() / 2);

        // create second hand
        Line secondHand = new Line(0, 0, 90, 0);
        secondHand.getTransforms().add(rotateSecondHand);
        secondHand.setTranslateX(secondHand.getBoundsInLocal().getWidth() / 2);

        // create hour hand
        Shape hourHand = new Path(
                new MoveTo(0, 0),
                new LineTo(20, -8),
                new LineTo(60, 0),
                new LineTo(20, 8),
                new ClosePath());
        hourHand.setFill(Color.LIGHTGRAY);
        hourHand.getTransforms().add(rotateHourHand);
        hourHand.setTranslateX(hourHand.getBoundsInLocal().getWidth() / 2);

        root = new StackPane(minuteHand, hourHand, secondHand);
        root.setMinSize(200, 200);
                
        // binding hands to the model value
        control.timeProperty().addListener((e, oldValue, newValue) -> {
                    rotateSecondHand.setAngle(newValue.getSeconds() * 6 - 90);
                    rotateMinuteHand.setAngle(newValue.getMinutes() * 6 - 90);
                    rotateHourHand.setAngle(newValue.getHours() * 30 - 90);
                });
    }

    @Override
    public ClockControl getSkinnable() {
        return control;
    }

    @Override
    public Node getNode() {
        return root;
    }

    @Override
    public void dispose() {
    }
}

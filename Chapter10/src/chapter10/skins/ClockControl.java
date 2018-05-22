/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter10.skins;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 */
// now as we are making a proper control we can base it on JavaFX Control class
public class ClockControl extends Control {
    
    // enum to select between our skin types
    public enum SkinType { HANDS, TEXT };
    private final SkinType skinType;

    // implementing a method from Skinnable interface
    @Override
    protected Skin<?> createDefaultSkin() {
        if (skinType == SkinType.HANDS) 
            return new ClockSkinHands(this);
        else 
            return new ClockSkinText(this);
    }

    // this is our model data — time
    final ObjectProperty<Date> timeProp = new SimpleObjectProperty<>(new Date());
    public ObjectProperty<Date> timeProperty() {
        return timeProp;
    }
    
    public ClockControl(SkinType skinType) {
        this.skinType = skinType;
        // this is out "business logic" — updating time value
        Timeline ttimer = new Timeline(new KeyFrame(Duration.seconds(1),
                (event) -> {
                    timeProp.setValue(new Date());
                }));
        ttimer.setCycleCount(Timeline.INDEFINITE);
        ttimer.playFrom(Duration.millis(999));
    }
}

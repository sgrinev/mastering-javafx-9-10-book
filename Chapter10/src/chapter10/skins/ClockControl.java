/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter10.skins;

import java.time.LocalDateTime;
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
    final ObjectProperty<LocalDateTime> timeProp = new SimpleObjectProperty<>(LocalDateTime.now());
    public ObjectProperty<LocalDateTime> timeProperty() {
        return timeProp;
    }
    
    public ClockControl(SkinType skinType) {
        this.skinType = skinType;
        // this is out "business logic" — updating time value
        Timeline ttimer = new Timeline(new KeyFrame(Duration.seconds(1),
                (event) -> {
                    timeProp.setValue(LocalDateTime.now());
                }));
        ttimer.setCycleCount(Timeline.INDEFINITE);
        ttimer.playFrom(Duration.millis(999));
    }
}

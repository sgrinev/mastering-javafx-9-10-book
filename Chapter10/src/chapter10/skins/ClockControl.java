/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter10.skins;

import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

/**
 *
 * @author sgrinev
 */
public class ClockControl extends Control {

    @Override
    protected Skin<?> createDefaultSkin() {
        return new ClockSkin(this);
    }

    final ObjectProperty<Date> timeProp = new SimpleObjectProperty<>();
    
    public ObjectProperty<Date> timeProperty() {
        return timeProp;
    }
    
    public ClockControl() {
        timeProp.setValue(new Date());
    }
}

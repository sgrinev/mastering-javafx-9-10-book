/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter10.table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author sgrinev
 */
public class ObservableChapter {

    private final StringProperty titleProp = new SimpleStringProperty();
    private final IntegerProperty numberProp = new SimpleIntegerProperty();

    ObservableChapter(int number, String title) {
        titleProp.set(title);
        numberProp.set(number);
    }

    // Title
    public String getTitle() {
        return titleProp.get();
    }

    public void setTitle(String title) {
        titleProp.set(title);
    }

//    public StringProperty titleProperty() {
//        return titleProp;
//    }

    // Number
    public int getNumber() {
        return numberProp.get();
    }

    public void setNumber(int number) {
        numberProp.set(number);
    }

    public IntegerProperty numberProperty() {
        return numberProp;
    }

    @Override
    public String toString() {
        return "ObservableChapter{" + getNumber() + ": " + getTitle() + '}';
    }

}

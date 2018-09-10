/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
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

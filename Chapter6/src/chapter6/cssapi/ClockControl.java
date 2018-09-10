/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter6.cssapi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.css.converter.PaintConverter;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 */
public class ClockControl extends BorderPane {

    private static final CssMetaData<ClockControl, Paint> HH_COLOR_METADATA = new CssMetaData("-fx-hh-color", PaintConverter.getInstance()) {
        @Override
        public boolean isSettable(Styleable styleable) {
            return !((ClockControl) styleable).
                    hourHand.fillProperty().isBound();
        }

        @Override
        public StyleableProperty getStyleableProperty(Styleable styleable) {
            return ((ClockControl) styleable).
                    hourHandColorStyleableProperty;
        }

    };

    private SimpleStyleableObjectProperty<Paint> hourHandColorStyleableProperty = new SimpleStyleableObjectProperty(HH_COLOR_METADATA) {
        @Override
        protected void invalidated() {
            hourHand.setFill((Paint) get());
        }
    };
    
    private static final List<CssMetaData<? extends Styleable, ?>> cssMetaDataList;
    static {
        List<CssMetaData<? extends Styleable, ?>> temp =
            new ArrayList<>(BorderPane.getClassCssMetaData());
        temp.add(HH_COLOR_METADATA);
        cssMetaDataList = Collections.unmodifiableList(temp);
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return cssMetaDataList;
    }

    private final Text txtTime = new Text();
    private final Rotate rotateSecondHand = new Rotate(0, 0, 0);
    private final Rotate rotateMinuteHand = new Rotate(0, 0, 0);
    private final Rotate rotateHourHand = new Rotate(0, 0, 0);

    private final Shape hourHand;

    public ClockControl() {
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
        hourHand = new Path(
                new MoveTo(0, 0),
                new LineTo(20, -8),
                new LineTo(60, 0),
                new LineTo(20, 8),
                new ClosePath());
        hourHand.setFill(Color.LIGHTGRAY);
        hourHand.getTransforms().add(rotateHourHand);
        hourHand.setTranslateX(hourHand.getBoundsInLocal().getWidth() / 2);

        this.setCenter(new StackPane(minuteHand, hourHand, secondHand));
        this.setBottom(txtTime);
        BorderPane.setAlignment(txtTime, Pos.CENTER);
        
        Timeline ttimer = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            LocalDateTime now = LocalDateTime.now();
            String time = now.format(DateTimeFormatter.ofPattern("HH:MM:ss"));
            
            rotateSecondHand.setAngle(now.getSecond() * 6 - 90);
            rotateMinuteHand.setAngle(now.getMinute() * 6 - 90);
            rotateHourHand.setAngle(now.getHour() * 30 - 90);
            txtTime.setText(time);
        }));
        ttimer.setCycleCount(Timeline.INDEFINITE);
        ttimer.playFrom(Duration.millis(999));
    }

}

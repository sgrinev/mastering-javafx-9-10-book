/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter9.media;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class MediaVideoDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Media media = new Media("http://www.sample-videos.com/video/mp4/240/big_buck_bunny_240p_1mb.mp4");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        primaryStage.setTitle("VideoSpectrumDemo");
        primaryStage.setScene(new Scene(new Pane(mediaView), 320, 240));
        primaryStage.show();
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter9.media;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class MediaAudioDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //http://www.sample-videos.com/audio/mp3/crowd-cheering.mp3
        
        Pane root = new Pane();
        Line line = new Line(5, MID, 5, 0);
        root.getChildren().add(line);

        Media media = new Media("file:///c:/tmp/SampleAudio_0.7mb.mp3");
        MediaPlayer mp = new MediaPlayer(media);
        mp.setAudioSpectrumListener(new AudioSpectrumListener() {
            @Override
            public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {
//                System.out.print(timestamp + " " + magnitudes[6]);
                //line.setEndX(MID+magnitudes[6]);
//                for (int i = 0; i < 10; i++) {
//                    System.out.print(magnitudes[i] + " ");
//                }
//                System.out.println();
            }
        });
        
        

        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        mp.play();
    }
    private static final int MID = 150;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

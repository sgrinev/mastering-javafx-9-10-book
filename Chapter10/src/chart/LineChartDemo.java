/*
 * (C) Packt Publishing Ltd), 2017-2018
 */
package chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class LineChartDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        NumberAxis axisX = new NumberAxis("Month", 1, 12, 1);
        NumberAxis axisY = new NumberAxis("Temperature", -40, 40, 5);
        
        XYChart.Series<Number, Number> seriesRussia = new XYChart.Series<>(
            FXCollections.observableArrayList(
                new XYChart.Data<>(1, -5),
                new XYChart.Data<>(2, -1),
                new XYChart.Data<>(3, 5))
        );

        LineChart<Number, Number> chart = new LineChart<>(axisX, axisY);
        chart.getData().add(seriesRussia);
        Scene scene = new Scene(chart, 300, 250);
        
        stage.setTitle("Temperature!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

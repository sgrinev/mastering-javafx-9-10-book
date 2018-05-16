/*
 * (C) Packt Publishing Ltd), 2017-2018
 */
package chapter10.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class LineChartDemo extends Application {

    @Override
    public void start(Stage stage) {
        NumberAxis axisX = new NumberAxis("Month", 1, 12, 1);
        NumberAxis axisY = new NumberAxis();
        axisY.setLabel("Average Temperature (C)");

        XYChart.Series<Number, Number> seriesMoscow = new XYChart.Series<>(
                "Moscow",
                FXCollections.observableArrayList(
                        new XYChart.Data<>(1, -7),
                        new XYChart.Data<>(2, -6),
                        new XYChart.Data<>(3, 0),
                        new XYChart.Data<>(4, 7),
                        new XYChart.Data<>(5, 15),
                        new XYChart.Data<>(6, 18),
                        new XYChart.Data<>(7, 21),
                        new XYChart.Data<>(8, 19),
                        new XYChart.Data<>(9, 13),
                        new XYChart.Data<>(10, 6),
                        new XYChart.Data<>(11, 1),
                        new XYChart.Data<>(12, -4)
                ));

        XYChart.Series<Number, Number> seriesLondon = new XYChart.Series<>(
                "London",
                FXCollections.observableArrayList(
                        new XYChart.Data<>(1, 7),
                        new XYChart.Data<>(2, 7),
                        new XYChart.Data<>(3, 9),
                        new XYChart.Data<>(4, 12),
                        new XYChart.Data<>(5, 15),
                        new XYChart.Data<>(6, 18),
                        new XYChart.Data<>(7, 20),
                        new XYChart.Data<>(8, 20),
                        new XYChart.Data<>(9, 17),
                        new XYChart.Data<>(10, 13),
                        new XYChart.Data<>(11, 10),
                        new XYChart.Data<>(12, 7)
                ));

//        XYChart<Number, Number> chart = new LineChart<>(axisX, axisY);
        XYChart<Number, Number> chart = new AreaChart<>(axisX, axisY);
        chart.getData().addAll(seriesMoscow, seriesLondon);
        Scene scene = new Scene(chart, 500, 350);

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

/*
 * (C) Packt Publishing Ltd), 2017-2018
 */
package chapter10.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class CrazyLineChartDemo extends Application {

    @Override
    public void start(Stage stage) {
        NumberAxis axisX = new NumberAxis("Something", 1, 12, 1);
        NumberAxis axisY = new NumberAxis();
        axisY.setLabel("Something else");

        XYChart.Series<Number, Number> series = new XYChart.Series<>(
                "Nowhere",
                FXCollections.observableArrayList(
                        new XYChart.Data<>(3, 10),
                        new XYChart.Data<>(3, -5),
                        new XYChart.Data<>(5, -10),
                        new XYChart.Data<>(7, -10),
                        new XYChart.Data<>(9, -5),
                        new XYChart.Data<>(9, 10),
                        new XYChart.Data<>(7, 15),
                        new XYChart.Data<>(5, 15)
                ));

        LineChart<Number, Number> chart = new LineChart<>(axisX, axisY);
        chart.getData().addAll(series);
        Scene scene = new Scene(chart, 500, 350);

        stage.setTitle("Crazy graph!");
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

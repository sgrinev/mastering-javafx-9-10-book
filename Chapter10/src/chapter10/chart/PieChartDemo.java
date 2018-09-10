/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter10.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class PieChartDemo extends Application {

    @Override
    public void start(Stage stage) {

        ObservableList<PieChart.Data> data
                = FXCollections.observableArrayList(
                        new PieChart.Data("Luck", 10),
                        new PieChart.Data("Skill", 30),
                        new PieChart.Data("Power of Will", 15),
                        new PieChart.Data("Pleasure", 5),
                        new PieChart.Data("Pain", 40));

        PieChart chart = new PieChart(data);
        chart.setTitle("Success");
//        chart.setLabelsVisible(false);
//        chart.setLegendVisible(false);
        chart.setLegendSide(Side.LEFT);

        stage.setScene(new Scene(chart, 530, 400));
        stage.setTitle("Pie Chart Demo");
        stage.show();

        chart.setOnMouseClicked((e) -> {
            data.add(new PieChart.Data("Stuff", 10));
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}

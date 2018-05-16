/*
 * (C) Packt Publishing Ltd), 2017-2018
 */
package chapter10.chart;

import java.util.function.Supplier;
import java.util.stream.Stream;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class XYChartsDemo extends Application {

    @Override
    @SuppressWarnings("unchecked")
    public void start(Stage stage) {
        // we need a bit of lambdacraft to work with constructors
        Supplier<CategoryAxis> supplierX = () -> {
            return new CategoryAxis();
        };
        Supplier<NumberAxis> supplierY = () -> {
            NumberAxis axisY = new NumberAxis();
            axisY.setLabel("Average Temperature (C)");
            return axisY;
        };

        TilePane root = new TilePane(2, 2);

        Stream.of(
                // API is the same, only class name changes:
                new AreaChart<>(supplierX.get(), supplierY.get()),
                new BarChart<>(supplierX.get(), supplierY.get()),
                new LineChart<>(supplierX.get(), supplierY.get()),
                new ScatterChart<>(supplierX.get(), supplierY.get()),
                new StackedAreaChart<>(supplierX.get(), supplierY.get()),
                new StackedBarChart<>(supplierX.get(), supplierY.get())
        ).forEach((chart) -> {
            chart.setTitle(chart.getClass().getSimpleName());
            chart.setLegendVisible(false);
            chart.setPrefSize(350, 280);
            XYChart.Series<String, Number> seriesMoscow = new XYChart.Series<>(
                    "Moscow",
                    FXCollections.observableArrayList(
                            new XYChart.Data<>("January", -7),
                            new XYChart.Data<>("February", -6),
                            new XYChart.Data<>("March", 0),
                            new XYChart.Data<>("April", 7),
                            new XYChart.Data<>("May", 15),
                            new XYChart.Data<>("June", 18),
                            new XYChart.Data<>("July", 21),
                            new XYChart.Data<>("August", 19),
                            new XYChart.Data<>("September", 13),
                            new XYChart.Data<>("October", 6),
                            new XYChart.Data<>("November", 1),
                            new XYChart.Data<>("December", -4)
                    ));

            XYChart.Series<String, Number> seriesLondon = new XYChart.Series<>(
                    "London",
                    FXCollections.observableArrayList(
                            new XYChart.Data<>("January", 7),
                            new XYChart.Data<>("February", 7),
                            new XYChart.Data<>("March", 9),
                            new XYChart.Data<>("April", 12),
                            new XYChart.Data<>("May", 15),
                            new XYChart.Data<>("June", 18),
                            new XYChart.Data<>("July", 20),
                            new XYChart.Data<>("August", 20),
                            new XYChart.Data<>("September", 17),
                            new XYChart.Data<>("October", 13),
                            new XYChart.Data<>("November", 10),
                            new XYChart.Data<>("December", 7)
                    ));
            chart.getData().addAll(seriesLondon, seriesMoscow);
            chart.setOnMouseClicked((e) -> {
                // animated update demo
                seriesMoscow.getData().add(new XYChart.Data<>("Nonexistembr", Math.random() * 15));
            });
            root.getChildren().add(chart);
        });
        stage.setScene(new Scene(root, 500, 350));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package demo;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class F06_Rectangles extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();

        final int count = 7; //number of rectangles

//        NumberBinding minSide = Bindings
//                .min(root.heightProperty(), root.widthProperty())
//                .divide(count);
        
        NumberBinding minSide = Bindings
            .when(root.heightProperty().lessThan(root.widthProperty()) )
                .then( root.heightProperty() )
                .otherwise( root.widthProperty() )
            .divide(count);

        for (int x = 0; x < count; x++) {
            for (int y = 0; y < count; y++) {
                Rectangle rectangle = new Rectangle(0, 0, Color.LIGHTGRAY);

                rectangle.xProperty().bind(minSide.multiply(x));
                rectangle.yProperty().bind(minSide.multiply(y));
                rectangle.heightProperty().bind(minSide.subtract(2));
                rectangle.widthProperty().bind(rectangle.heightProperty());
                root.getChildren().add(rectangle);
            }
        }

        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

/*
Name: Madilyn Carpenter
Date: 02/08/2026
Assignment 4
Purpose: Create a siaplay of circles. 
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class circleDisplay extends Application {

    @Override
    public void start(Stage stage) {

        Circle c1 = new Circle(50);
        c1.getStyleClass().addAll("plaincircle", "circleborder");

        Circle c2 = new Circle(50);
        c2.getStyleClass().add("plaincircle");
        c2.setId("redcircle");

        Circle c3 = new Circle(50);
        c3.getStyleClass().add("plaincircle");
        c3.setId("greencircle");

        Circle c4 = new Circle(50);
        c4.getStyleClass().addAll("plaincircle", "circleborder");

        HBox pane = new HBox(20, c1, c2, c3, c4);
        pane.getStyleClass().add("border");

        Scene scene = new Scene(pane, 500, 200);
        scene.getStylesheets().add("mystyle.css");

        stage.setTitle("Circle Display");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

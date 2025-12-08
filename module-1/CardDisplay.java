/*
Name: Madilyn Carpenter
Date: 12/07/2025
Assignment 1
Purpose: Creates JavaFX UI to display randomly selected card images.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class CardDisplay extends Application {

    private HBox cardBox = new HBox();

    public void start(Stage stage) {

        showRandomCards();

        Button refresh = new Button("Refresh");
        refresh.setOnAction(e -> showRandomCards());

        VBox root = new VBox(cardBox, refresh);

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Card Display");
        stage.show();
    }

    private void showRandomCards() {
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 52; i++) deck.add(i);

        Collections.shuffle(deck);

        cardBox.getChildren().clear();

        for (int i = 0; i < 4; i++) {
            String file = "AssignmentCards/" + deck.get(i) + ".png";
            cardBox.getChildren().add(new ImageView(new Image(file)));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

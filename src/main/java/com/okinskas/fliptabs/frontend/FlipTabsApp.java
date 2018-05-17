package com.okinskas.fliptabs.frontend;

import com.okinskas.fliptabs.entity.Board;
import com.okinskas.fliptabs.entity.Game;
import com.okinskas.fliptabs.entity.Tab;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class FlipTabsApp extends Application {

    private final Game game = new Game();
    private static final int PADDING = 10;
    private static final int BUTTON_PADDING = 30;
    private static final String BUTTON_COLOUR_OFF = "#ffffff";
    private static final String BUTTON_COLOUR_ON = "#000000";

    private Map<Button, Tab> buttonTabMap = new HashMap<Button, Tab>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        final Board board = game.getBoard();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(PADDING));
        grid.setVgap(PADDING);
        grid.setHgap(PADDING);

        for (int r = 0; r < Board.BOARD_X; r++) {
            for (int c = 0; c < Board.BOARD_Y; c++) {
                final Tab tab = board.getTab(r, c);
                int state = tab.getState();
                final Button button = new Button();
                button.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        board.flipSequence(tab.x, tab.y);
                        updateBoard();
                    }
                });
                buttonTabMap.put(button, tab);
                String colour = state ==  1 ? BUTTON_COLOUR_ON : BUTTON_COLOUR_OFF;
                button.setStyle("-fx-padding: " + BUTTON_PADDING
                        + "; -fx-background-color: " + colour);
                grid.add(button, r, c);
            }
        }

        ScrollPane scrollPane = new ScrollPane(grid);
        primaryStage.setScene(new Scene(scrollPane));
        primaryStage.show();
    }

    private void updateBoard() {
        for (Button b : buttonTabMap.keySet()) {
            int state = buttonTabMap.get(b).getState();
            String colour = state ==  1 ? BUTTON_COLOUR_ON : BUTTON_COLOUR_OFF;
            b.setStyle("-fx-padding: " + BUTTON_PADDING
                    + "; -fx-background-color: " + colour);
        }

        if (game.hasWon()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Congratulations, you won!");
            alert.showAndWait();
        }
    }
}

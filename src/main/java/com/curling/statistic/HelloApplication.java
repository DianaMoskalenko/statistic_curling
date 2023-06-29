package com.curling.statistic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class HelloApplication extends Application {

    enum GameStats {
    SCORE_ONE,
    SCORE_TWO,
    SCORE_THREE,
    SCORE_FOUR,
    POSITION_LEAD,
    POSITION_SECOND,
    POSITION_THIRD,
    POSITION_FOURTH,
    TURN_IN_P,
    TURN_IN_O,
    TURN_OUT_P,
    TURN_OUT_O
}
@Override
public void start(Stage primaryStage) {


        primaryStage.setTitle("Curling Statistics");

        Label positionLabel = new Label("Position:");
        Button positionButton1 = new Button("Lead");
        Button positionButton2 = new Button("Second");
        Button positionButton3 = new Button("Third");
        Button positionButton4 = new Button("Fourth");

        Label scoreLabel = new Label("Score:");
        Button scoreButton1 = new Button("1");
        Button scoreButton2 = new Button("2");
        Button scoreButton3 = new Button("3");
        Button scoreButton4 = new Button("4");


        Label turnLabel = new Label("Turn:");
        Button turnButton1 = new Button("In_P");
        Button turnButton2 = new Button("In_O");
        Button turnButton3 = new Button("Out_P");
        Button turnButton4 = new Button("Out_O");

        // Создание сетки и настройка размещения элементов
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.addRow(0, positionLabel, positionButton1, positionButton2, positionButton3, positionButton4);
        gridPane.addRow(1, scoreLabel, scoreButton1, scoreButton2, scoreButton3, scoreButton4);
        gridPane.addRow(2, turnLabel, turnButton1, turnButton2, turnButton3, turnButton4);

        positionButton1.setOnAction(e -> handleButtonAction(GameStats.POSITION_LEAD));
        positionButton2.setOnAction(e -> handleButtonAction(GameStats.POSITION_SECOND));
        positionButton3.setOnAction(e -> handleButtonAction(GameStats.POSITION_THIRD));
        positionButton4.setOnAction(e -> handleButtonAction(GameStats.POSITION_FOURTH));

        scoreButton1.setOnAction(e -> handleButtonAction(GameStats.SCORE_ONE));
        scoreButton2.setOnAction(e -> handleButtonAction(GameStats.SCORE_TWO));
        scoreButton3.setOnAction(e -> handleButtonAction(GameStats.SCORE_THREE));
        scoreButton4.setOnAction(e -> handleButtonAction(GameStats.SCORE_FOUR));

        turnButton1.setOnAction(e -> handleButtonAction(GameStats.TURN_IN_P));
        turnButton2.setOnAction(e -> handleButtonAction(GameStats.TURN_IN_O));
        turnButton3.setOnAction(e -> handleButtonAction(GameStats.TURN_OUT_P));
        turnButton4.setOnAction(e -> handleButtonAction(GameStats.TURN_OUT_O));

        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
        }

private void handleButtonAction(GameStats gameStat) {
        // Обработка нажатия кнопки и выполнение действий
        System.out.println("Button clicked: " + gameStat.name());
        // Здесь можно добавить код для записи в файл Excel или выполнения других операций
        }

public static void main(String[] args) {

    launch(args);
        }

}

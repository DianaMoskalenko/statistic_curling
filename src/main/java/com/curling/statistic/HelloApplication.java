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
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class HelloApplication extends Application {

    ExcelWriter excelWriter = new ExcelWriter("statistic.xlsx");


    enum GameStats {
        POSITION_LEAD,
        POSITION_SECOND,
        POSITION_THIRD,
        POSITION_FOURTH,
        SCORE_ONE,
        SCORE_TWO,
        SCORE_THREE,
        SCORE_FOUR,

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

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.addRow(0, positionLabel, positionButton1, positionButton2, positionButton3, positionButton4);
        gridPane.addRow(1, scoreLabel, scoreButton1, scoreButton2, scoreButton3, scoreButton4);


        positionButton1.setOnAction(e -> handleButtonAction(GameStats.POSITION_LEAD));
        positionButton2.setOnAction(e -> handleButtonAction(GameStats.POSITION_SECOND));
        positionButton3.setOnAction(e -> handleButtonAction(GameStats.POSITION_THIRD));
        positionButton4.setOnAction(e -> handleButtonAction(GameStats.POSITION_FOURTH));

        scoreButton1.setOnAction(e -> handleButtonAction(GameStats.SCORE_ONE));
        scoreButton2.setOnAction(e -> handleButtonAction(GameStats.SCORE_TWO));
        scoreButton3.setOnAction(e -> handleButtonAction(GameStats.SCORE_THREE));
        scoreButton4.setOnAction(e -> handleButtonAction(GameStats.SCORE_FOUR));



        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void handleButtonAction(GameStats gameStat) {
        System.out.println("Button clicked: " + gameStat.name());
        excelWriter.handleButtonAction(gameStat);
    }

    public static void main(String[] args) {

        launch(args);
    }

}
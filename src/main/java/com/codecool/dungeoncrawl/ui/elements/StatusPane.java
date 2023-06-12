package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label swordTextLabel;
    private Label swordValueLabel;
    private Label keyTextLabel;
    private Label keyValueLabel;
    private List<Label> inventoryList = new ArrayList<>();

    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();
        swordTextLabel = new Label("Sword: ");
        swordValueLabel = new Label();
        keyTextLabel = new Label("Key: ");
        keyValueLabel = new Label();
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);
        ui.add(swordTextLabel, 2, 0);
        ui.add(swordValueLabel, 3, 0);
        ui.add(keyTextLabel, 4, 0);
        ui.add(keyValueLabel, 5, 0);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }
    public  void  setSwordValue(String text){
        swordValueLabel.setText(text);
    }
    public  void  setKeyValue(String text){
        keyValueLabel.setText(text);
    }
}

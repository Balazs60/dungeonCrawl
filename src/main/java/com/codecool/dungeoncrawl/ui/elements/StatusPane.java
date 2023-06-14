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
    private  Label potionTextLabel;
    private Label potionValueLabel;
    private Label tresureTextLabel;
    private Label tresureValueLabel;

    private List<Label> inventoryList = new ArrayList<>();

    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();
        swordTextLabel = new Label("Sword: ");
        swordValueLabel = new Label();
        keyTextLabel = new Label("Key: ");
        keyValueLabel = new Label();
        potionTextLabel = new Label("Potion: ");
        potionValueLabel = new Label();
        tresureTextLabel = new Label("Tresure");
        tresureValueLabel = new Label();
    }

    public BorderPane build() {

        int row = 0;

        ui.add(healthTextLabel, 0, row);
        ui.add(healthValueLabel, 1, row);
        row++;

        ui.add(swordTextLabel, 0, row);
        ui.add(swordValueLabel, 1, row);
        row++;

        ui.add(keyTextLabel, 0, row);
        ui.add(keyValueLabel, 1, row);
        row++;

        ui.add(potionTextLabel, 0, row);
        ui.add(potionValueLabel, 1, row);
        row++;

        ui.add(tresureTextLabel, 0, row);
        ui.add(tresureValueLabel, 1, row);

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
    public  void setPotionValue(String text) {potionValueLabel.setText(text);}
    public  void setTresureValue(String text) {tresureValueLabel.setText(text);}
}

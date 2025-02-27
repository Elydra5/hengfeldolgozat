package com.example;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {

    Double radius;
    Double height;
    Double result;

    @FXML
    private TextField heightText;

    @FXML
    private TextField radiusText;

    @FXML
    private TextField resultText;

    @FXML
    void saveBtn(ActionEvent event) throws SQLException {
        String heightString = heightText.getText();
        String radiusString = radiusText.getText();
        if (heightString.isEmpty() || radiusString.isEmpty()) {
            System.err.println("Kérlek adj meg minden adatot!");
            return;
        }
        try {
            height = Double.parseDouble(heightString);
            radius = Double.parseDouble(radiusString);
            result = 2 * Math.PI * radius * (radius * height);
            resultText.setText(String.valueOf(result));
            DBConnector db = new DBConnector();
            db.connect();
            db.addRecord(radius, height, result);
        } catch (NumberFormatException e) {
            System.err.println("Hibás formátum!");
        }
    }

    @FXML
    void exitBtn(ActionEvent event) {
        System.exit(0);
    }
}

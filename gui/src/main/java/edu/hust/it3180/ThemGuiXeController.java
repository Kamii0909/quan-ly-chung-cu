package edu.hust.it3180;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ThemGuiXeController {
    @FXML
    private TextField tenChuHo, soNha, soXeMay, soOTo;

    public void save(ActionEvent actionEvent) {
        String chuHoValue = tenChuHo.getText();
        String soNhaValue = soNha.getText();
        String soXeMayValue = soXeMay.getText();
        String soOToValue = soOTo.getText();

        if (chuHoValue.isEmpty() || soNhaValue.isEmpty() || (soXeMayValue.isEmpty() && soOToValue.isEmpty())) {
            showAlert("Error", "Vui long dien day du thong tin!", Alert.AlertType.ERROR);
            return;
        }

        Data.guiXeList.add(new GuiXeFee(3, chuHoValue, soNhaValue, 0,1, 1200000, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),"da nhan"));

        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void cancel(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

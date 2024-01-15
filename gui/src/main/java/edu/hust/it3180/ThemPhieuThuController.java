package edu.hust.it3180;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ThemPhieuThuController implements Initializable {
    @FXML
    private TextField tenChuHo, soNha, money;
    @FXML
    private ComboBox feeType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void save(ActionEvent event) {
        String chuHoValue = tenChuHo.getText();
        String soNhaValue = soNha.getText();
        String loaiPhi = feeType.getValue().toString();
        String soTien = money.getText();

        if (chuHoValue.isEmpty() || soNhaValue.isEmpty() || loaiPhi == null || soTien.isEmpty()) {
            showAlert("Error", "Vui long dien day du thong tin!", Alert.AlertType.ERROR);
            return;
        }

        Data.tuNguyenList.add(new TuNguyenFee(3, chuHoValue, soNhaValue, 100000,0,0,0,0,0,0,0,0,"da nhan"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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

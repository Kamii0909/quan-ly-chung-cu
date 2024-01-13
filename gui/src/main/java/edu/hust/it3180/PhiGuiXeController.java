package edu.hust.it3180;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class PhiGuiXeController implements Initializable {
    @FXML
    private Label currentTime, sumPaid;
    @FXML
    private TableView phiGuiXeTable;
    @FXML
    private TableColumn STT, tenChuHo, soNha, xeMay, oTo,tongPhi, ngay, trangThai;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateCurrentTime();
    }
    private void updateCurrentTime() {
        // Get real time
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        String formattedThoiGian = now.format(formatter);

        // Update time for label
        currentTime.setText(formattedThoiGian);
    }
}

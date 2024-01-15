package edu.hust.it3180;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class PhiQuanLyController implements Initializable {
    @FXML
    private Label currentTime, sumPaid;
    @FXML
    private TableView phiQuanLyTable;
    @FXML
    private TableColumn STT, tenChuHo, soNha, dienTich, tongPhi, ngay, trangThai;
    @FXML
    private Button payButton;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateCurrentTime();
        updateCurrentTime();
        Data.dichVuList.clear();
        Data.dichVuList.add(new DichVuFee(1, "Nguyen Van A", "0503", 80.5F, 563500, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), true));
        Data.dichVuList.add(new DichVuFee(2, "Tran Thi B", "0702", 65.2F, 456400, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), true));
        Data.dichVuList.add(new DichVuFee(3, "Le Van C", "1009", 100.0F, 700000, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), true));
        Data.dichVuList.add(new DichVuFee(4, "Phung Van D", "0111", 70.0F, 490000, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), false));
        STT.setCellValueFactory(new PropertyValueFactory<>("stt"));
        tenChuHo.setCellValueFactory(new PropertyValueFactory<>("tenChuHo"));
        soNha.setCellValueFactory(new PropertyValueFactory<>("soNha"));
        dienTich.setCellValueFactory(new PropertyValueFactory<>("dienTich"));
        tongPhi.setCellValueFactory(new PropertyValueFactory<>("tien"));
        ngay.setCellValueFactory(new PropertyValueFactory<>("ngay"));
        trangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));

        phiQuanLyTable.setItems(Data.dichVuList);
    }
    private void updateCurrentTime() {
        // Get real time
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        String formattedThoiGian = now.format(formatter);

        // Update time for label
        currentTime.setText(formattedThoiGian);
    }

    public void pay(ActionEvent actionEvent) {
    }
}

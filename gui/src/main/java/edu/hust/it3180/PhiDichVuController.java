package edu.hust.it3180;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class PhiDichVuController implements Initializable {
    @FXML
    private Label currentTime, sumPaid, sumMoney;
    @FXML
    private TableView phiDichVuTable;
    @FXML
    private TableColumn STT, tenChuHo, soNha, dienTich, tongPhi, ngay, trangThai;
    @FXML
    private Button payButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateCurrentTime();
        Data.dichVuList.clear();
        Data.dichVuList.add(new DichVuFee(1, "Nguyen Van A", "0503", 80.5F, 805000, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), true));
        Data.dichVuList.add(new DichVuFee(2, "Tran Thi B", "0702", 65.2F, 625000, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), true));
        Data.dichVuList.add(new DichVuFee(3, "Le Van C", "1009", 100.0F, 1000000, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), true));
        Data.dichVuList.add(new DichVuFee(4, "Phung Van D", "0111", 70.0F, 700000, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), false));
        STT.setCellValueFactory(new PropertyValueFactory<>("stt"));
        tenChuHo.setCellValueFactory(new PropertyValueFactory<>("tenChuHo"));
        soNha.setCellValueFactory(new PropertyValueFactory<>("soNha"));
        dienTich.setCellValueFactory(new PropertyValueFactory<>("dienTich"));
        tongPhi.setCellValueFactory(new PropertyValueFactory<>("tien"));
        ngay.setCellValueFactory(new PropertyValueFactory<>("ngay"));
        trangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));

        phiDichVuTable.setItems(Data.dichVuList);
    }

    private void updateCurrentTime() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedThoiGian = now.format(formatter);

        currentTime.setText(formattedThoiGian);
    }

    public void pay(ActionEvent actionEvent) {
        Data.dichVuList.remove(3);
        Data.dichVuList.add(new DichVuFee(4, "Phung Van D", "0111", 70.0F, 700000, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), true));
        payButton.setVisible(false);
        sumPaid.setText("4/4");
        sumMoney.setText("3130000");
    }
}

package edu.hust.it3180;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoHoKhauController implements Initializable {
    @FXML
    private TextField tenChuHo, soNha, idChuHo;
    @FXML
    private DatePicker ngaySinhChuHo;
    @FXML
    private TableView<ThanhVien> thanhVienTable;
    @FXML
    private TableColumn<ThanhVien, String> tenThanhVienColumn;

    @FXML
    private TableColumn<ThanhVien, String> ngaySinhColumn;

    @FXML
    private TableColumn<ThanhVien, String> idThanhVienColumn;

    @FXML
    private TableColumn<ThanhVien, String> quanHeColumn;

    private HoKhau hoKhau;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tenThanhVienColumn.setCellValueFactory(cellData -> cellData.getValue().tenProperty());
        ngaySinhColumn.setCellValueFactory(cellData -> cellData.getValue().ngaySinhProperty());
        idThanhVienColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        quanHeColumn.setCellValueFactory(cellData -> cellData.getValue().quanHeProperty());
    }

    public void setData(HoKhau hoKhau) {
        this.hoKhau = hoKhau;
        showHoKhauInfo();
    }

    // Hiển thị thông tin hộ khẩu lên giao diện
    private void showHoKhauInfo() {
        tenChuHo.setText(hoKhau.getTenChuHo());
        soNha.setText(hoKhau.getSoNha());

        // Hiển thị thông tin thành viên lên TableView
        thanhVienTable.setItems(hoKhau.getThanhVienList());
    }
}

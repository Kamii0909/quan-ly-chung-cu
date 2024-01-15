package edu.hust.it3180;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<ThanhVien, String> tenThanhVien;

    @FXML
    private TableColumn<ThanhVien, String> ngaySinhThanhVien;

    @FXML
    private TableColumn<ThanhVien, String> idThanhVien;

    @FXML
    private TableColumn<ThanhVien, String> quanHe;

    private HoKhau hoKhau;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tenChuHo.setText(Data.hoKhauInfo.getTenChuHo());
        soNha.setText(Data.hoKhauInfo.getSoNha());
        idChuHo.setText(Data.hoKhauInfo.getId());
        Data.memberList.clear();
        Data.memberList.add(new ThanhVien("Bui Thi X", "Nguyen Van A", "08/10/2000", "789312456", "vo"));
        Data.memberList.add(new ThanhVien("Nguyen Van M", "Nguyen Van A", "1/11/2008", "", "con"));

//        ngaySinhChuHo.setText(Data.hoKhauInfo.getTenChuHo());
//        Data.hoKhauInfo;
        tenThanhVien.setCellValueFactory(cellData -> cellData.getValue().tenProperty());
        ngaySinhThanhVien.setCellValueFactory(cellData -> cellData.getValue().ngaySinhProperty());
        idThanhVien.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        quanHe.setCellValueFactory(cellData -> cellData.getValue().quanHeProperty());

        thanhVienTable.setItems(Data.memberList);
    }

    public void setData(HoKhau selectedHoKhau) {
        this.hoKhau = hoKhau;
        showHoKhauInfo(selectedHoKhau);
    }

    private void showHoKhauInfo(HoKhau selectedHoKhau) {
//        if (hoKhau != null) {
//            tenChuHo.setText(hoKhau.getTenChuHo());
//            soNha.setText(hoKhau.getSoNha());
//            idChuHo.setText(String.valueOf(hoKhau.getIdChuHo()));
//            // ... (hiển thị các thông tin khác tương tự)
//        }
    }
}

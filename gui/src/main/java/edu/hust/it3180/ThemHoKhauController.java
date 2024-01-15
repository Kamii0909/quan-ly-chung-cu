package edu.hust.it3180;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ThemHoKhauController implements Initializable {
    @FXML
    private TextField tenChuHo, soNha, idChuHo;
    @FXML
    private TableView<ThanhVien> thanhVienTable;
    @FXML
    private TableColumn<ThanhVien, String> tenThanhVien, ngaySinhThanhVien, idThanhVien, quanHe;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tenThanhVien.setCellValueFactory(new PropertyValueFactory<>("tenThanhVien"));
        ngaySinhThanhVien.setCellValueFactory(new PropertyValueFactory<>("ngaySinhThanhVien"));
        idThanhVien.setCellValueFactory(new PropertyValueFactory<>("idThanhVien"));
        quanHe.setCellValueFactory(new PropertyValueFactory<>("quanHe"));
    }

    public void save(ActionEvent event) {
//        Data.hoKhauList.add(new HoKhau(4, "Nguyen Van A", "123456789", "0503", 80.5, 3));
        String tenChuHoValue = tenChuHo.getText();
        String soNhaValue = soNha.getText();
        String idChuHoValue = idChuHo.getText();

        String tenThanhVienValue = tenThanhVien.getCellData(thanhVienTable.getSelectionModel().getSelectedItem());;
        String ngaySinhValue = ngaySinhThanhVien.getCellData(thanhVienTable.getSelectionModel().getSelectedItem());;
        String idThanhVienValue = idThanhVien.getCellData(thanhVienTable.getSelectionModel().getSelectedItem());;
        String quanHeValue = quanHe.getCellData(thanhVienTable.getSelectionModel().getSelectedItem());;

        Data.hoKhauList.add(new HoKhau(4, tenChuHoValue, idChuHoValue, soNhaValue, 70.0, 0));
        Data.memberList.add(new ThanhVien(tenThanhVienValue, tenChuHoValue, ngaySinhValue, idThanhVienValue, quanHeValue));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}

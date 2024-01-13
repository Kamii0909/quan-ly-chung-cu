package edu.hust.it3180;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ThemHoKhauController implements Initializable {
    @FXML
    private TextField tenChuHo, soNha, idChuHo;
    @FXML
    private TableView thanhVienTable;
    @FXML
    private TableColumn tenThanhVien, ngaySinhThanhVien, idThanhVien, quanHe;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void save(ActionEvent event) {
//        HoKhauModel model = new HoKhauModel();
//        NhanKhauModel tempModel = PersonUtil.getInstance().getMonitor();

//        model.setId(id.getText());
//        model.setSoNha(Integer.valueOf(soNha.getText()));
//        model.setTenChuHo(tempModel.getHoTen());
//
//        ApartmentUtil.getInstance().add(model);
//        apartmentService.save(model);
//
//        List<NhanKhauModel> list = new ArrayList<>(thanhVienTable.getItems());
//        for(NhanKhauModel nhanKhauModel : list) {
//            nhanKhauModel.setIdHoKhau(model.getId());
//            nhanKhauService.update(nhanKhauModel);
//        }
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}

package edu.hust.it3180;

import edu.hust.it3180.api.BillingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class KhoanTuNguyenController implements Initializable {
    @FXML
    private TableColumn STT, tenChuHo, soNha, quy1, quy2, quy3, quy4, quy5, quy6, quy7, quy8, quy9, xacNhan;
    @FXML
    private TableView khoanTuNguyenTable;
    @FXML
    private Label sumMoney;

    static {
        Data.tuNguyenList.clear();
        Data.tuNguyenList.add(new TuNguyenFee(1,"Nguyen Van A", "0503", 50000, 20000, 100000,30000,0,0,0,50000,100000, "da nhan"));
        Data.tuNguyenList.add(new TuNguyenFee(2,"Le Van C", "1009", 70000, 0, 0,100000,200000,0,100000,50000,0, "da nhan"));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        STT.setCellValueFactory(new PropertyValueFactory<>("stt"));
        tenChuHo.setCellValueFactory(new PropertyValueFactory<>("tenChuHo"));
        soNha.setCellValueFactory(new PropertyValueFactory<>("soNha"));
        quy1.setCellValueFactory(new PropertyValueFactory<>("quy1"));
        quy2.setCellValueFactory(new PropertyValueFactory<>("quy2"));
        quy3.setCellValueFactory(new PropertyValueFactory<>("quy3"));
        quy4.setCellValueFactory(new PropertyValueFactory<>("quy4"));
        quy5.setCellValueFactory(new PropertyValueFactory<>("quy5"));
        quy6.setCellValueFactory(new PropertyValueFactory<>("quy6"));
        quy7.setCellValueFactory(new PropertyValueFactory<>("quy7"));
        quy8.setCellValueFactory(new PropertyValueFactory<>("quy8"));
        quy9.setCellValueFactory(new PropertyValueFactory<>("quy9"));
        xacNhan.setCellValueFactory(new PropertyValueFactory<>("xacNhan"));

        khoanTuNguyenTable.setItems(Data.tuNguyenList);
    }


    public void newFeeReceipt(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemHoKhauController.class.getResource("ThemPhieuThuView.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
        sumMoney.setText("970000");
    }

}

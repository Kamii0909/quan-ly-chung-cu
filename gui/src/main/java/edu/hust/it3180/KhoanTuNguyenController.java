package edu.hust.it3180;

import edu.hust.it3180.api.BillingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class KhoanTuNguyenController {
    @FXML
    private TableView khoanTuNguyenTable;
    @FXML
    private TableColumn STT, tenChuHo, soNha, quy1, quy2, quy3, quy4, quy5, quy6, quy7, quy8, quy9, trangThai;
    @FXML
    private Label sum;

    private BillingSystem system;


    public void newFeeReceipt(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemHoKhauController.class.getResource("ThemPhieuThuView.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
    }
}

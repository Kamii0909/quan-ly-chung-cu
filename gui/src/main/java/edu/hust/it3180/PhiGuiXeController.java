package edu.hust.it3180;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class PhiGuiXeController implements Initializable {
    @FXML
    private Label currentTime;
    @FXML
    private TableView phiGuiXeTable;
    @FXML
    private TableColumn STT, tenChuHo, soNha, soXeMay, soOTo, tien, ngay, trangThai;

    static {
        Data.guiXeList.clear();
        Data.guiXeList.add(new GuiXeFee(1, "Nguyen Van A", "0503", 1, 1, 1270000, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "da nhan"));
        Data.guiXeList.add(new GuiXeFee(2, "Tran Thi B", "0702", 2, 0, 140000, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "da nhan"));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateCurrentTime();
        STT.setCellValueFactory(new PropertyValueFactory<>("stt"));
        tenChuHo.setCellValueFactory(new PropertyValueFactory<>("tenChuHo"));
        soNha.setCellValueFactory(new PropertyValueFactory<>("soNha"));
        soXeMay.setCellValueFactory(new PropertyValueFactory<>("soXeMay"));
        soOTo.setCellValueFactory(new PropertyValueFactory<>("soOTo"));
        tien.setCellValueFactory(new PropertyValueFactory<>("tien"));
        ngay.setCellValueFactory(new PropertyValueFactory<>("ngay"));
        trangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));

        phiGuiXeTable.setItems(Data.guiXeList);
    }
    private void updateCurrentTime() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedThoiGian = now.format(formatter);

        currentTime.setText(formattedThoiGian);
    }

    public void newGuiXeFee(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemHoKhauController.class.getResource("ThemGuiXeView.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
    }
}

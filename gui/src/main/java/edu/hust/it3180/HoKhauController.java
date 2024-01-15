package edu.hust.it3180;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HoKhauController implements Initializable {
//    @FXML
//    private TableView hoKhauTable;
//    @FXML
//    private TableColumn STT, tenChuHo, id, soNha, area, member;
    @FXML
    private TableView<HoKhau> hoKhauTable;
    @FXML
    private TableColumn<HoKhau, Integer> STT;
    @FXML
    private TableColumn<HoKhau, String> tenChuHo;
    @FXML
    private TableColumn<HoKhau, String> id;
    @FXML
    private TableColumn<HoKhau, String> soNha;
    @FXML
    private TableColumn<HoKhau, Double> area;
    @FXML
    private TableColumn<HoKhau, Integer> member;
    @FXML
    private TableColumn<HoKhau, Void> chiTiet;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        hoKhauList = FXCollections.observableArrayList();
//        Data.hoKhauList.add()
        // Thêm dữ liệu giả mạo
        Data.hoKhauList.add(new HoKhau(1, "Nguyen Van A", "123456789", "0503", 80.5, 3));
        Data.hoKhauList.add(new HoKhau(2, "Tran Thi B", "987654321", "0702", 65.2, 2));
        Data.hoKhauList.add(new HoKhau(3, "Le Van C", "456789012", "1009", 100.0, 4));

        // Liên kết cột với thuộc tính của HoKhau
        STT.setCellValueFactory(new PropertyValueFactory<>("stt"));
        tenChuHo.setCellValueFactory(new PropertyValueFactory<>("tenChuHo"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        soNha.setCellValueFactory(new PropertyValueFactory<>("soNha"));
        area.setCellValueFactory(new PropertyValueFactory<>("area"));
        member.setCellValueFactory(new PropertyValueFactory<>("member"));
        chiTiet.setCellFactory(param -> new TableCell<>() {
            private final Button button = new Button("Chi tiet");
            {
                button.setOnAction(event -> {
                    HoKhau hoKhau = getTableView().getItems().get(getIndex());
                    chiTietButtonClick(hoKhau);
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });

        hoKhauTable.setItems(Data.hoKhauList);
    }

    private void chiTietButtonClick(HoKhau selectedHoKhau) {
        try {
            Data.hoKhauInfo = selectedHoKhau;
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(InfoHoKhauController.class.getResource("InfoHoKhauView.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Thông tin hộ khẩu");
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newApartment(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemHoKhauController.class.getResource("ThemHoKhauView.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
//        Data.hoKhauList.add(new HoKhau(4, "Nguyen Van A", "123456789", "0503", 80.5, 3));
//        Data.hoKhauList.add(new HoKhau(5, "Tran Thi B", "987654321", "0702", 65.2, 2));
//        Data.hoKhauList.add(new HoKhau(6, "Le Van C", "456789012", "1009", 100.0, 4));

    }
}

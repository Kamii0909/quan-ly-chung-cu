package edu.hust.it3180;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HoKhauController {
    @FXML
    private TableView hoKhauTable;
    @FXML
    private TableColumn STT, tenChuHo, id, soNha, area, member;
    public void newApartment(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemHoKhauController.class.getResource("ThemHoKhauView.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
    }
}

package edu.hust.it3180;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class TrangChuController implements Initializable {
    @FXML
    private AnchorPane application;
    @FXML
    private Label sumFamily, sumVehicle;
    @FXML
    private Button login;
    @FXML
    private ComboBox<String> feeType;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login.setText("Admin");
    }
    private <T> void setAnchorConstraint(T pane) {
        Double v = 0.0;
        AnchorPane.setTopAnchor((Node) pane, v);
        AnchorPane.setBottomAnchor((Node) pane, v);
        AnchorPane.setLeftAnchor((Node) pane, v);
        AnchorPane.setRightAnchor((Node) pane, v);
    }
    public void selectFeeType(javafx.event.ActionEvent actionEvent) {
        String selectedFeeType = feeType.getValue();
        System.out.println(selectedFeeType);
        switch (selectedFeeType) {
            case "Phi dich vu":
                showPhiDichVu();
                break;
            case "Phi quan ly":
                showPhiQuanLy();
                break;
            case "Phi gui xe":
                showPhiGuiXe();
                break;
            case "Khoan tu nguyen":
                showKhoanTuNguyen();
                break;
            default: break;
        }
    }
    private void showPhiDichVu() {
        application.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PhiDichVuView.fxml"));
            Node phiDichVuView = loader.load();
            application.getChildren().add(phiDichVuView);

            setAnchorConstraint(phiDichVuView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showPhiQuanLy() {
        application.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PhiQuanLyView.fxml"));
            Node phiQuanLyView = loader.load();
            application.getChildren().add(phiQuanLyView);

            setAnchorConstraint(phiQuanLyView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showPhiGuiXe() {
        application.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PhiGuiXeView.fxml"));
            Node PhiGuiXeView = loader.load();
            application.getChildren().add(PhiGuiXeView);

            setAnchorConstraint(PhiGuiXeView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showKhoanTuNguyen() {
        application.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("KhoanTuNguyenView.fxml"));
            Node KhoanTuNguyen = loader.load();
            application.getChildren().add(KhoanTuNguyen);
            setAnchorConstraint(KhoanTuNguyen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showHoKhau() {
        application.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HoKhauView.fxml"));
            Node HoKhau = loader.load();
            application.getChildren().add(HoKhau);
            setAnchorConstraint(HoKhau);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showThongKe() {
//        application.getChildren().clear();
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("ThongKeView.fxml"));
//            Node ThongKe = loader.load();
//            application.getChildren().add(ThongKe);
//            setAnchorConstraint(ThongKe);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    public void showTrangChu(ActionEvent actionEvent) {
        application.getChildren().clear();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TrangChu2View.fxml"));
            Node trangChu = loader.load();
            application.getChildren().add(trangChu);
            setAnchorConstraint(trangChu);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        // Đóng cửa sổ
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("JavaFX and Gradle");
        stage.setScene(scene);
        stage.show();
    }
}
package edu.hust.it3180;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class TrangChuController implements Initializable {
    @FXML
    private AnchorPane application;
    @FXML
    private Label loginLabel;
    @FXML
    private ComboBox<String> feeType;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginLabel.setText("Login as");
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
            case "Phi dien, nuoc, internet":
                showPhiDienNuoc();
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
    private void showPhiDienNuoc() {

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
}
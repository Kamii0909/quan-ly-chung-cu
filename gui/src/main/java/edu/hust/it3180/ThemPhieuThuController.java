package edu.hust.it3180;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ThemPhieuThuController implements Initializable {
    @FXML
    private TextField tenChuHo, soNha, otherFee, money;
    @FXML
    private ComboBox feeType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void save(ActionEvent event) {
        /*
        * Action save
         */


        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void cancel(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }


}

package edu.hust.it3180;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Button loginButton;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void login(ActionEvent actionEvent) throws Exception {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();
        Admin admin = new Admin(1, "admin", "123");

        // So sánh dữ liệu nhập với thông tin Admin cố định
        if (enteredUsername.equals(admin.getUsername()) && enteredPassword.equals(admin.getPassword())) {
            openTrangChuView(new Stage());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            // Đóng cửa sổ
            stage.close();
        } else {
            // Nếu sai, hiển thị thông báo lỗi
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Đăng nhập thất bại");
            alert.setContentText("Sai username hoặc password");
            alert.showAndWait();
        }
    }

    private void openTrangChuView(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TrangChuView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("JavaFX and Gradle");
        stage.setScene(scene);
        stage.show();
    }
}

package edu.hust.it3180;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ThanhVien {
    private StringProperty ten;
    private StringProperty ngaySinh;
    private String tenChuHo;
    private StringProperty id;
    private StringProperty quanHe;

    public ThanhVien(String ten, String tenChuHo, String ngaySinh, String id, String quanHe) {
        this.ten = new SimpleStringProperty(ten);
        this.tenChuHo = tenChuHo;
        this.ngaySinh = new SimpleStringProperty(ngaySinh);
        this.id = new SimpleStringProperty(id);
        this.quanHe = new SimpleStringProperty(quanHe);
    }

    // Getter methods

    public StringProperty tenProperty() {
        return ten;
    }

    public StringProperty ngaySinhProperty() {
        return ngaySinh;
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty quanHeProperty() {
        return quanHe;
    }


    public String getTen() {
        return ten.get();
    }

    public String getNgaySinh() { return ngaySinh.get(); }

    public String getId() {
        return id.get();
    }

    public String getQuanHe() {
        return quanHe.get();
    }
}

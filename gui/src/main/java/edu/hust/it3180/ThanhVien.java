package edu.hust.it3180;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ThanhVien {
    private final StringProperty ten;
    private final StringProperty ngaySinh;
    private final StringProperty id;
    private final StringProperty quanHe;

    public ThanhVien(String ten, String ngaySinh, String id, String quanHe) {
        this.ten = new SimpleStringProperty(ten);
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

    // Các phương thức getter thông thường nếu cần

    public String getTen() {
        return ten.get();
    }

    public String getNgaySinh() {
        return ngaySinh.get();
    }

    public String getId() {
        return id.get();
    }

    public String getQuanHe() {
        return quanHe.get();
    }
}

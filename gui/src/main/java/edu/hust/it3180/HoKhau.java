package edu.hust.it3180;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HoKhau {
    private int stt;
    private String tenChuHo;
    private String id;
    private String soNha;
    private double area;
    private int member;

    public HoKhau(int stt, String tenChuHo, String id, String soNha, double area, int member) {
        this.stt = stt;
        this.tenChuHo = tenChuHo;
        this.id = id;
        this.soNha = soNha;
        this.area = area;
        this.member = member;
    }

    public int getStt() {
        return stt;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public String getId() {
        return id;
    }

    public String getSoNha() {
        return soNha;
    }

    public double getArea() {
        return area;
    }

    public int getMember() {
        return member;
    }
    public ObservableList<ThanhVien> getThanhVienList() {
        ObservableList<ThanhVien> thanhVienList = FXCollections.observableArrayList();

        thanhVienList.add(new ThanhVien("Nguyen Van A", "", "01/01/1990", "123456789", "Con"));
        thanhVienList.add(new ThanhVien("Tran Thi B", "", "05/05/1995", "987654321", "Cháu"));

        return thanhVienList;
    }
}

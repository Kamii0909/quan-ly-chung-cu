package edu.hust.it3180;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Data {
    public static ArrayList<Admin> listAdmin = new ArrayList<Admin>();
    static {
        listAdmin.add(new Admin(1, "admin", "123"));
    }
    public static ObservableList<HoKhau> hoKhauList = FXCollections.observableArrayList();
    public static HoKhau hoKhauInfo;

    public static ObservableList<ThanhVien> memberList = FXCollections.observableArrayList();

    public static ObservableList<DichVuFee> dichVuList = FXCollections.observableArrayList();
    static {
        dichVuList.add(new DichVuFee(1, "Nguyen Van A", "0503", 80.5F, 805000,LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), true));
    }


}

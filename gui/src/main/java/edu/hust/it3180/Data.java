package edu.hust.it3180;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Admin> listAdmin = new ArrayList<Admin>();
    static {
        listAdmin.add(new Admin(1, "admin", "123"));
    }
    public static ObservableList<HoKhau> hoKhauList = FXCollections.observableArrayList();
    public static HoKhau hoKhauInfo;

    public static ObservableList<HoKhau> memberList = FXCollections.observableArrayList();
}

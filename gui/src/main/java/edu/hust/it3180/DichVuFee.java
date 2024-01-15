package edu.hust.it3180;

public class DichVuFee {
    private int stt;
    private String tenChuHo;
    private String soNha;
    private float dienTich;
    private int tien;
    private String ngay;
    private boolean trangThai;

    public DichVuFee(int stt, String tenChuHo, String soNha, float dienTich, int tien, String ngay, boolean trangThai){
        this.stt = stt;
        this.tenChuHo = tenChuHo;
        this.soNha = soNha;
        this.dienTich = dienTich;
        this.tien = tien;
        this.ngay = ngay;
        this.trangThai = trangThai;
    }
    public int getStt() {
        return stt;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public String getSoNha() {
        return soNha;
    }

    public float getDienTich() {
        return dienTich;
    }

    public int getTien() {
        return tien;
    }

    public String getNgay() {
        return ngay;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}

package edu.hust.it3180;

public class GuiXeFee {
    private int stt;
    private String tenChuHo;
    private String soNha;
    private int soXeMay;
    private int soOTo;
    private int tien;
    private String ngay;
    private String trangThai;

    public GuiXeFee(int stt, String tenChuHo, String soNha, int soXeMay,
                    int soOTo, int tien, String ngay, String trangThai) {
        this.stt = stt;
        this.tenChuHo = tenChuHo;
        this.soNha = soNha;
        this.soXeMay = soXeMay;
        this.soOTo = soOTo;
        this.tien = tien;
        this.ngay = ngay;
        this.trangThai = trangThai;
    }

    public int getStt() {
        return stt;
    }
    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }
    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public String getSoNha() {
        return soNha;
    }
    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public int getSoXeMay() {
        return soXeMay;
    }
    public void setSoXeMay(int soXeMay) {
        this.soXeMay = soXeMay;
    }

    public int getSoOTo() {
        return soOTo;
    }
    public void setSoOTo(int soOTo) {
        this.soOTo = soOTo;
    }

    public int getTien() {
        return tien;
    }
    public void setTien(int tien) {
        this.tien = tien;
    }

    public String getNgay() {
        return ngay;
    }
    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String isTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

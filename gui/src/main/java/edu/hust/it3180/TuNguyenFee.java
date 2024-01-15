package edu.hust.it3180;

public class TuNguyenFee {
    private int stt;
    private String tenChuHo;
    private String soNha;
    private int quy1, quy2, quy3, quy4, quy5, quy6, quy7, quy8, quy9;
    private String xacNhan;

    public TuNguyenFee(int stt, String tenChuHo, String soNha, int quy1, int quy2, int quy3,
                       int quy4, int quy5, int quy6, int quy7, int quy8, int quy9, String xacNhan) {
        this.stt = stt;
        this.tenChuHo = tenChuHo;
        this.soNha = soNha;
        this.quy1 = quy1; this.quy2 = quy2; this.quy3 = quy3;
        this.quy4 = quy4; this.quy5 = quy5; this.quy6 = quy6;
        this.quy7 = quy7; this.quy8 = quy8; this.quy9 = quy9;
        this.xacNhan = xacNhan;
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

    public int getQuy1() {
        return quy1;
    }
    public void setQuy1(int quy1) {
        this.quy1 = quy1;
    }

    public int getQuy2() {
        return quy2;
    }
    public void setQuy2(int quy1) {
        this.quy2 = quy2;
    }

    public int getQuy3() {
        return quy3;
    }
    public void setQuy3(int quy3) {
        this.quy3 = quy3;
    }

    public int getQuy4() {
        return quy4;
    }
    public void setQuy4(int quy4) {
        this.quy4 = quy4;
    }

    public int getQuy5() {
        return quy5;
    }
    public void setQuy5(int quy5) {
        this.quy5 = quy5;
    }

    public int getQuy6() {
        return quy6;
    }
    public void setQuy6(int quy6) {
        this.quy6 = quy6;
    }

    public int getQuy7() {
        return quy7;
    }
    public void setQuy7(int quy7) {
        this.quy7 = quy7;
    }

    public int getQuy8() {
        return quy8;
    }
    public void setQuy8(int quy8) {
        this.quy8 = quy8;
    }

    public int getQuy9() {
        return quy9;
    }
    public void setQuy9(int quy9) {
        this.quy9 = quy9;
    }

    public String getXacNhan() {
        return xacNhan;
    }
    public void setXacNhan(String xacNhan) {
        this.xacNhan = xacNhan;
    }
}

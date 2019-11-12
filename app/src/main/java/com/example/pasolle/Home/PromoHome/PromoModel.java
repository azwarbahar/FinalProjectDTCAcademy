package com.example.pasolle.Home.PromoHome;

public class PromoModel {
private String nama;
private int gambar;

    public PromoModel() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public PromoModel(String nama, int gambar) {
        this.nama = nama;
        this.gambar = gambar;
    }
}

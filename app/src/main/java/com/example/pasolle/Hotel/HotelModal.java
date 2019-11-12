package com.example.pasolle.Hotel;

public class HotelModal {

    private String nmaa_hotel;
    private String alamat_hotel;
    private String harga_hotel;
    private String deskripsi_hotel;
    private int gambar1_hotel;
    private int gambar2_hotel;
    private int gambar3_hotel;

    public HotelModal(){

    }

    public String getNmaa_hotel() {
        return nmaa_hotel;
    }

    public void setNmaa_hotel(String nmaa_hotel) {
        this.nmaa_hotel = nmaa_hotel;
    }

    public String getAlamat_hotel() {
        return alamat_hotel;
    }

    public void setAlamat_hotel(String alamat_hotel) {
        this.alamat_hotel = alamat_hotel;
    }

    public String getHarga_hotel() {
        return harga_hotel;
    }

    public void setHarga_hotel(String harga_hotel) {
        this.harga_hotel = harga_hotel;
    }

    public String getDeskripsi_hotel() {
        return deskripsi_hotel;
    }

    public void setDeskripsi_hotel(String deskripsi_hotel) {
        this.deskripsi_hotel = deskripsi_hotel;
    }

    public int getGambar1_hotel() {
        return gambar1_hotel;
    }

    public void setGambar1_hotel(int gambar1_hotel) {
        this.gambar1_hotel = gambar1_hotel;
    }

    public int getGambar2_hotel() {
        return gambar2_hotel;
    }

    public void setGambar2_hotel(int gambar2_hotel) {
        this.gambar2_hotel = gambar2_hotel;
    }

    public int getGambar3_hotel() {
        return gambar3_hotel;
    }

    public void setGambar3_hotel(int gambar3_hotel) {
        this.gambar3_hotel = gambar3_hotel;
    }

    public HotelModal(String nmaa_hotel, String alamat_hotel, String harga_hotel, String deskripsi_hotel, int gambar1_hotel, int gambar2_hotel, int gambar3_hotel) {
        this.nmaa_hotel = nmaa_hotel;
        this.alamat_hotel = alamat_hotel;
        this.harga_hotel = harga_hotel;
        this.deskripsi_hotel = deskripsi_hotel;
        this.gambar1_hotel = gambar1_hotel;
        this.gambar2_hotel = gambar2_hotel;
        this.gambar3_hotel = gambar3_hotel;
    }
}

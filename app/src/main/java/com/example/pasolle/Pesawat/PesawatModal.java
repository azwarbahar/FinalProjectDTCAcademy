package com.example.pasolle.Pesawat;

import android.os.Parcel;
import android.os.Parcelable;

public class PesawatModal implements Parcelable {
    private String dari;
    private String tujuan;
    private String tanggal;
    private String Jumlah;
    private String pesawat_nama;
    private int pesawat_gambar;

    protected PesawatModal(Parcel in) {
        dari = in.readString();
        tujuan = in.readString();
        tanggal = in.readString();
        Jumlah = in.readString();
        pesawat_nama = in.readString();
        pesawat_gambar = in.readInt();
    }

    public static final Creator<PesawatModal> CREATOR = new Creator<PesawatModal>() {
        @Override
        public PesawatModal createFromParcel(Parcel in) {
            return new PesawatModal(in);
        }

        @Override
        public PesawatModal[] newArray(int size) {
            return new PesawatModal[size];
        }
    };

    public PesawatModal() {

    }

    public String getDari() {
        return dari;
    }

    public void setDari(String dari) {
        this.dari = dari;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJumlah() {
        return Jumlah;
    }

    public void setJumlah(String jumlah) {
        Jumlah = jumlah;
    }

    public String getPesawat_nama() {
        return pesawat_nama;
    }

    public void setPesawat_nama(String pesawat_nama) {
        this.pesawat_nama = pesawat_nama;
    }

    public int getPesawat_gambar() {
        return pesawat_gambar;
    }

    public void setPesawat_gambar(int pesawat_gambar) {
        this.pesawat_gambar = pesawat_gambar;
    }

    public PesawatModal(String dari, String tujuan, String tanggal, String jumlah, String pesawat_nama, int pesawat_gambar) {
        this.dari = dari;
        this.tujuan = tujuan;
        this.tanggal = tanggal;
        Jumlah = jumlah;
        this.pesawat_nama = pesawat_nama;
        this.pesawat_gambar = pesawat_gambar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dari);
        parcel.writeString(tujuan);
        parcel.writeString(tanggal);
        parcel.writeString(Jumlah);
        parcel.writeString(pesawat_nama);
        parcel.writeInt(pesawat_gambar);
    }
}

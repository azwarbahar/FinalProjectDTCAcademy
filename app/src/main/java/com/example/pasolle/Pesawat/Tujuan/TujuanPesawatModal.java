package com.example.pasolle.Pesawat.Tujuan;

import android.os.Parcel;
import android.os.Parcelable;

public class TujuanPesawatModal implements Parcelable {

    private String nama_tujuan;
    private String nama_dari;
    private String singkatan_tujuan;
    private String singkatan_dari;
    private String bandara_tujuan;
    private String bandara_dari;
    private String kode_maksud;

    public String getNama_tujuan() {
        return nama_tujuan;
    }

    public void setNama_tujuan(String nama_tujuan) {
        this.nama_tujuan = nama_tujuan;
    }

    public String getNama_dari() {
        return nama_dari;
    }

    public void setNama_dari(String nama_dari) {
        this.nama_dari = nama_dari;
    }

    public String getSingkatan_tujuan() {
        return singkatan_tujuan;
    }

    public void setSingkatan_tujuan(String singkatan_tujuan) {
        this.singkatan_tujuan = singkatan_tujuan;
    }

    public String getSingkatan_dari() {
        return singkatan_dari;
    }

    public void setSingkatan_dari(String singkatan_dari) {
        this.singkatan_dari = singkatan_dari;
    }

    public String getBandara_tujuan() {
        return bandara_tujuan;
    }

    public void setBandara_tujuan(String bandara_tujuan) {
        this.bandara_tujuan = bandara_tujuan;
    }

    public String getBandara_dari() {
        return bandara_dari;
    }

    public void setBandara_dari(String bandara_dari) {
        this.bandara_dari = bandara_dari;
    }

    public String getKode_maksud() {
        return kode_maksud;
    }

    public void setKode_maksud(String kode_maksud) {
        this.kode_maksud = kode_maksud;
    }

    public TujuanPesawatModal(){

    }

    public TujuanPesawatModal(String nama_tujuan, String nama_dari, String singkatan_tujuan, String singkatan_dari, String bandara_tujuan, String bandara_dari, String kode_maksud) {
        this.nama_tujuan = nama_tujuan;
        this.nama_dari = nama_dari;
        this.singkatan_tujuan = singkatan_tujuan;
        this.singkatan_dari = singkatan_dari;
        this.bandara_tujuan = bandara_tujuan;
        this.bandara_dari = bandara_dari;
        this.kode_maksud = kode_maksud;
    }

    protected TujuanPesawatModal(Parcel in) {
        nama_tujuan = in.readString();
        nama_dari = in.readString();
        singkatan_tujuan = in.readString();
        singkatan_dari = in.readString();
        bandara_tujuan = in.readString();
        bandara_dari = in.readString();
        kode_maksud = in.readString();
    }

    public static final Creator<TujuanPesawatModal> CREATOR = new Creator<TujuanPesawatModal>() {
        @Override
        public TujuanPesawatModal createFromParcel(Parcel in) {
            return new TujuanPesawatModal(in);
        }

        @Override
        public TujuanPesawatModal[] newArray(int size) {
            return new TujuanPesawatModal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama_tujuan);
        parcel.writeString(nama_dari);
        parcel.writeString(singkatan_tujuan);
        parcel.writeString(singkatan_dari);
        parcel.writeString(bandara_tujuan);
        parcel.writeString(bandara_dari);
        parcel.writeString(kode_maksud);
    }
}

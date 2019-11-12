package com.example.pasolle.Home.Populer;

import android.os.Parcel;
import android.os.Parcelable;

public class PopulerModel implements Parcelable {

    private String titel;
    private String deskripsi;
    private int gambar;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public PopulerModel(String titel, String deskripsi, int gambar) {
        this.titel = titel;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public PopulerModel() {

    }

    protected PopulerModel(Parcel in) {
        this.titel = in.readString();
        this.deskripsi = in.readString();
        this.gambar = in.readInt();
    }

    public static final Creator<PopulerModel> CREATOR = new Creator<PopulerModel>() {
        @Override
        public PopulerModel createFromParcel(Parcel in) {
            return new PopulerModel(in);
        }

        @Override
        public PopulerModel[] newArray(int size) {
            return new PopulerModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titel);
        parcel.writeString(deskripsi);
        parcel.writeInt(gambar);
    }
}

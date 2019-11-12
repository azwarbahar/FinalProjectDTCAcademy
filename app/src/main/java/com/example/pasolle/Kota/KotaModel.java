package com.example.pasolle.Kota;

import android.os.Parcel;
import android.os.Parcelable;

public class KotaModel implements Parcelable {

    private String title_kota;
    private int image_kota;

    public KotaModel() {

    }

    protected KotaModel(Parcel in) {
        title_kota = in.readString();
        image_kota = in.readInt();
    }

    public static final Creator<KotaModel> CREATOR = new Creator<KotaModel>() {
        @Override
        public KotaModel createFromParcel(Parcel in) {
            return new KotaModel(in);
        }

        @Override
        public KotaModel[] newArray(int size) {
            return new KotaModel[size];
        }
    };

    public String getTitle_kota() {
        return title_kota;
    }

    public void setTitle_kota(String title_kota) {
        this.title_kota = title_kota;
    }

    public int getImage_kota() {
        return image_kota;
    }

    public void setImage_kota(int image_kota) {
        this.image_kota = image_kota;
    }

    public KotaModel(String title_kota, int image_kota) {
        this.title_kota = title_kota;
        this.image_kota = image_kota;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title_kota);
        parcel.writeInt(image_kota);
    }
}

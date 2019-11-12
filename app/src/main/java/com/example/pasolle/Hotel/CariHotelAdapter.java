package com.example.pasolle.Hotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pasolle.Kota.KotaAdapter;
import com.example.pasolle.Kota.KotaModel;
import com.example.pasolle.R;

import java.util.ArrayList;

public class CariHotelAdapter extends RecyclerView.Adapter<CariHotelAdapter.Myviewholdercarihotel> {


    Context mContext;
    ArrayList<HotelModal> hotelModals;

    public CariHotelAdapter(Context mContext, ArrayList<HotelModal> hotelModals) {
        this.mContext = mContext;
        this.hotelModals = hotelModals;
    }

    @NonNull
    @Override
    public Myviewholdercarihotel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_cari_hotel, parent, false);
        CariHotelAdapter.Myviewholdercarihotel vHolder = new CariHotelAdapter.Myviewholdercarihotel(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholdercarihotel holder, int position) {

        holder.titel_cari_hotel.setText(hotelModals.get(position).getNmaa_hotel());
        holder.alamat_cari_hotel.setText(hotelModals.get(position).getAlamat_hotel());
        holder.harga_cari_hotel.setText(hotelModals.get(position).getHarga_hotel());
        Glide.with(mContext)
                .load(hotelModals.get(position).getGambar1_hotel())
                .into(holder.image1_cari_hotel);
        Glide.with(mContext)
                .load(hotelModals.get(position).getGambar2_hotel())
                .into(holder.image2_cari_hotel);

    }

    @Override
    public int getItemCount() {
        return hotelModals.size();
    }

    public class Myviewholdercarihotel extends RecyclerView.ViewHolder {

        private TextView  titel_cari_hotel;
        private TextView  alamat_cari_hotel;
        private TextView  harga_cari_hotel;
        private ImageView image1_cari_hotel;
        private ImageView image2_cari_hotel;

        public Myviewholdercarihotel(@NonNull View itemView) {
            super(itemView);

            titel_cari_hotel = itemView.findViewById(R.id.titel_cari_hotel);
            alamat_cari_hotel = itemView.findViewById(R.id.alamat_cari_hotel);
            harga_cari_hotel = itemView.findViewById(R.id.harga_cari_hotel);
            image1_cari_hotel = itemView.findViewById(R.id.image1_cari_hotel);
            image2_cari_hotel = itemView.findViewById(R.id.image2_cari_hotel);

        }
    }
}

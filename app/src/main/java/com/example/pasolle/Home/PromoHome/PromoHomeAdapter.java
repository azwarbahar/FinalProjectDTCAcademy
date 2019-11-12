package com.example.pasolle.Home.PromoHome;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pasolle.R;

import java.util.ArrayList;


public class PromoHomeAdapter extends RecyclerView.Adapter<PromoHomeAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<PromoModel> mDataPromo;

    public PromoHomeAdapter(Context mContext, ArrayList<PromoModel> mDataPromo) {
        this.mContext = mContext;
        this.mDataPromo = mDataPromo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_promo_home, parent, false);
        MyViewHolder vHolder = new  MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nama.setText(mDataPromo.get(position).getNama());
        Glide.with(mContext)
                .load(mDataPromo.get(position).getGambar())
                .into(holder.poster);

    }

    @Override
    public int getItemCount() {
        return mDataPromo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView poster;
        private TextView nama;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            poster = (ImageView) itemView.findViewById(R.id.image_promo_home);
            nama = (TextView) itemView.findViewById(R.id.namapromo);
        }
    }
}

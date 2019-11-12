package com.example.pasolle.Pesawat;

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
import com.example.pasolle.R;

import java.util.ArrayList;

public class PesawatAdapter extends RecyclerView.Adapter<PesawatAdapter.MyHolderPesawat> {
    Context mContext;
    ArrayList<PesawatModal> pesawatModals;

    public PesawatAdapter(Context mContext, ArrayList<PesawatModal> pesawatModals) {
        this.mContext = mContext;
        this.pesawatModals = pesawatModals;
    }

    @NonNull
    @Override
    public MyHolderPesawat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_pesawat, parent, false);
        PesawatAdapter.MyHolderPesawat vHolder = new PesawatAdapter.MyHolderPesawat(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderPesawat holder, int position) {

        holder.nama_pesawat.setText(pesawatModals.get(position).getPesawat_nama());
        Glide.with(mContext)
                .load(pesawatModals.get(position).getPesawat_gambar())
                .into(holder.image_pesawat);


    }

    @Override
    public int getItemCount() {
        return pesawatModals.size();
    }

    public class MyHolderPesawat extends RecyclerView.ViewHolder {
        private ImageView image_pesawat;
        private TextView nama_pesawat;
        public MyHolderPesawat(@NonNull View itemView) {
            super(itemView);

            image_pesawat = itemView.findViewById(R.id.image_pesawat);
            nama_pesawat = itemView.findViewById(R.id.nama_pesawat);
        }
    }
}

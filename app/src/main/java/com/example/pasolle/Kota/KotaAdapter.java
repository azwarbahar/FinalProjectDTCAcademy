package com.example.pasolle.Kota;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pasolle.DetailWisataActivity;
import com.example.pasolle.Home.Populer.PopulerAdapter;
import com.example.pasolle.Home.Populer.PopulerModel;
import com.example.pasolle.Kota.DetailKota.KotaDetailActivity;
import com.example.pasolle.R;

import java.util.ArrayList;

public class KotaAdapter extends RecyclerView.Adapter<KotaAdapter.MyholderKota> {

    Context mContext;
    ArrayList<KotaModel> kotaModels;

    public KotaAdapter(Context mContext, ArrayList<KotaModel> kotaModels) {
        this.mContext = mContext;
        this.kotaModels = kotaModels;
    }

    @NonNull
    @Override
    public MyholderKota onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_kota, parent, false);
        KotaAdapter.MyholderKota vHolder = new KotaAdapter.MyholderKota(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyholderKota holder, final int position) {
        holder.title_kota.setText(kotaModels.get(position).getTitle_kota());
        Glide.with(mContext)
                .load(kotaModels.get(position).getImage_kota())
                .into(holder.image_kota);

        holder.image_kota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, KotaDetailActivity.class);
                intent.putExtra(KotaDetailActivity.EXTRA_DATA, kotaModels.get(position));
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return kotaModels.size();
    }

    public class MyholderKota extends RecyclerView.ViewHolder {

        private TextView title_kota;
        private ImageView image_kota;

        public MyholderKota(@NonNull View itemView) {
            super(itemView);

            title_kota = itemView.findViewById(R.id.titel_kota);
            image_kota = itemView.findViewById(R.id.image_kota);
        }
    }
}

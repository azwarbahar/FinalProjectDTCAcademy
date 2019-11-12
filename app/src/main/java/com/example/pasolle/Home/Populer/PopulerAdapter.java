package com.example.pasolle.Home.Populer;

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
import com.example.pasolle.R;

import java.util.ArrayList;

public class PopulerAdapter extends RecyclerView.Adapter<PopulerAdapter.MyViewHolderPopuler> {

    Context mContext;
    ArrayList<PopulerModel> mDatapopuler;

    public PopulerAdapter(Context mContext, ArrayList<PopulerModel> mDatapopuler) {
        this.mContext = mContext;
        this.mDatapopuler = mDatapopuler;
    }



    @NonNull
    @Override
    public MyViewHolderPopuler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_populer_home, parent, false);
        PopulerAdapter.MyViewHolderPopuler vHolder = new PopulerAdapter.MyViewHolderPopuler(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPopuler holder, final int position) {

        holder.tv_title.setText(mDatapopuler.get(position).getTitel());
        Glide.with(mContext)
                .load(mDatapopuler.get(position).getGambar())
                .into(holder.imageView);


        holder.tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailWisataActivity.class);
                intent.putExtra(DetailWisataActivity.EXTRA_DATA, mDatapopuler.get(position));
                mContext.startActivity(intent);
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailWisataActivity.class);
                intent.putExtra(DetailWisataActivity.EXTRA_DATA, mDatapopuler.get(position));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatapopuler.size();
    }

    public class MyViewHolderPopuler extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private ImageView imageView;

        public MyViewHolderPopuler(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.titel_populer);
            imageView = itemView.findViewById(R.id.image_populer);
        }


    }
}

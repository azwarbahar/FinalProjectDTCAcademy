package com.example.pasolle.Pesawat.Tujuan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasolle.Pesawat.PesawatFragment;
import com.example.pasolle.R;

import java.util.ArrayList;

public class TujuanPesawatAdapter extends RecyclerView.Adapter<TujuanPesawatAdapter.MyHoldertuTuanPesawat> {


    Context mContext;
    ArrayList<TujuanPesawatModal> tujuanPesawatModals;

    public TujuanPesawatAdapter(Context mContext, ArrayList<TujuanPesawatModal> tujuanPesawatModals) {
        this.mContext = mContext;
        this.tujuanPesawatModals = tujuanPesawatModals;
    }

    @NonNull
    @Override
    public MyHoldertuTuanPesawat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_tujuan_pesawat, parent, false);
        TujuanPesawatAdapter.MyHoldertuTuanPesawat vHolder = new TujuanPesawatAdapter.MyHoldertuTuanPesawat(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHoldertuTuanPesawat holder, final int position) {



        holder.item_tujuan_pesawat_tv.setText(tujuanPesawatModals.get(position).getBandara_dari());
        String secondata = tujuanPesawatModals.get(position).getBandara_dari();

        holder.getkode.setText(tujuanPesawatModals.get(position).getKode_maksud());

       String sendata = tujuanPesawatModals.get(position).getKode_maksud();
//                Toast.makeText(mContext, sendata, Toast.LENGTH_SHORT).show();

        if (sendata=="1"){
            holder.item_tujuan_pesawat_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Fragment pesatatFragment = new PesawatFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("to", tujuanPesawatModals.get(position).getNama_tujuan());
                    bundle.putString("from", tujuanPesawatModals.get(position).getBandara_dari());
                    bundle.putString("kode", "1");
                    pesatatFragment.setArguments(bundle);
                    AppCompatActivity compatActivity = (AppCompatActivity)view.getContext();
                    compatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, pesatatFragment).addToBackStack(null).commit();
                }
            });

        } else  if (sendata=="2"){
            holder.item_tujuan_pesawat_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Fragment pesatatFragment = new PesawatFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("from", tujuanPesawatModals.get(position).getBandara_dari());
                    bundle.putString("to", tujuanPesawatModals.get(position).getNama_tujuan());
                    bundle.putString("kode", "2");
                    pesatatFragment.setArguments(bundle);
                    AppCompatActivity compatActivity = (AppCompatActivity)view.getContext();
                    compatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, pesatatFragment).addToBackStack(null).commit();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return tujuanPesawatModals.size();
    }

    public class MyHoldertuTuanPesawat extends RecyclerView.ViewHolder {

        private TextView item_tujuan_pesawat_tv;
        private TextView getkode;

        public MyHoldertuTuanPesawat(@NonNull View itemView) {
            super(itemView);

            item_tujuan_pesawat_tv = itemView.findViewById(R.id.item_tujuan_pesawat_tv);
            getkode = itemView.findViewById(R.id.getkode);
        }
    }
}

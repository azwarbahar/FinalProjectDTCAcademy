package com.example.pasolle.Kota;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasolle.Home.PromoHome.PromoModel;
import com.example.pasolle.R;

import java.util.ArrayList;

public class KotaFragment extends Fragment {
    View v;

    private String[] kotadatatitel;
    private TypedArray kotadataimage;
    private RecyclerView recyclerViewKota;
    private ArrayList<KotaModel> kotaModelArrayList;

    public KotaFragment(){

    }

    private ArrayList<KotaModel> tambahItemkota(){

        kotadatatitel = getResources().getStringArray(R.array.titel_kota);
        kotadataimage = getResources().obtainTypedArray(R.array.gambar_kota);

        ArrayList<KotaModel> listnyakota = new ArrayList<>();

        for(int a = 0; a < kotadatatitel.length; a++){
            KotaModel kotaModel = new KotaModel();
            kotaModel.setTitle_kota(kotadatatitel[a]);
            kotaModel.setImage_kota(kotadataimage.getResourceId(a, -1));
            listnyakota.add(kotaModel);
        }
        return listnyakota;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        kotaModelArrayList = tambahItemkota();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_kota, container, false);

        recyclerViewKota = v.findViewById(R.id.kota_rv);

        KotaAdapter kotaAdapter = new KotaAdapter(getContext(), kotaModelArrayList);
        recyclerViewKota.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerViewKota.setAdapter(kotaAdapter);

        return v;
    }
}

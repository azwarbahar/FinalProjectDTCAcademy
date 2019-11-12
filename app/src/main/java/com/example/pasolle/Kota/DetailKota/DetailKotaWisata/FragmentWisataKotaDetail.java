package com.example.pasolle.Kota.DetailKota.DetailKotaWisata;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasolle.Home.Populer.PopulerAdapter;
import com.example.pasolle.Home.Populer.PopulerModel;
import com.example.pasolle.Home.PromoHome.PromoModel;
import com.example.pasolle.Kota.DetailKota.KotaDetailActivity;
import com.example.pasolle.R;

import java.util.ArrayList;

public class FragmentWisataKotaDetail extends Fragment {
    View v;

    private String[] datatitlepopuler;
    private String[] datadeskripsipopuler;
    private TypedArray dataFotopopuler;
    private TextView getname;

    private RecyclerView recyclerView;
    private ArrayList<PopulerModel> populerModelArrayList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    public FragmentWisataKotaDetail(){

    }

    private ArrayList<PopulerModel> tambahItemmakassar(  ){
        datatitlepopuler = getResources().getStringArray(R.array.wisata_makassar);
        datadeskripsipopuler = getResources().getStringArray(R.array.deskripsi_makassar);
        dataFotopopuler = getResources().obtainTypedArray(R.array.gambar_makassar);


        ArrayList<PopulerModel> listnyapopuler = new ArrayList<>();

        for(int i = 0; i < datatitlepopuler.length; i++){
            PopulerModel populerModel = new PopulerModel();
            populerModel.setTitel(datatitlepopuler[i]);
            populerModel.setDeskripsi(datadeskripsipopuler[i]);
            populerModel.setGambar(dataFotopopuler.getResourceId(i, -1));
            listnyapopuler.add(populerModel);
        }
        return listnyapopuler;

    }

    private ArrayList<PopulerModel> tambahItemmaros(){

            datatitlepopuler = getResources().getStringArray(R.array.wisata_maros);
            datadeskripsipopuler = getResources().getStringArray(R.array.deskripsi_maros);
            dataFotopopuler = getResources().obtainTypedArray(R.array.gambar_maros);


        ArrayList<PopulerModel> listnyapopuler = new ArrayList<>();

        for(int i = 0; i < datatitlepopuler.length; i++){
            PopulerModel populerModel = new PopulerModel();
            populerModel.setTitel(datatitlepopuler[i]);
            populerModel.setDeskripsi(datadeskripsipopuler[i]);
            populerModel.setGambar(dataFotopopuler.getResourceId(i, -1));
            listnyapopuler.add(populerModel);
        }
        return listnyapopuler;

    }


    private ArrayList<PopulerModel> tambahItemtoraja(){

            datatitlepopuler = getResources().getStringArray(R.array.wisata_toraja);
            datadeskripsipopuler = getResources().getStringArray(R.array.deskripsi_toraja);
            dataFotopopuler = getResources().obtainTypedArray(R.array.gambar_toraja);

        ArrayList<PopulerModel> listnyapopuler = new ArrayList<>();

        for(int i = 0; i < datatitlepopuler.length; i++){
            PopulerModel populerModel = new PopulerModel();
            populerModel.setTitel(datatitlepopuler[i]);
            populerModel.setDeskripsi(datadeskripsipopuler[i]);
            populerModel.setGambar(dataFotopopuler.getResourceId(i, -1));
            listnyapopuler.add(populerModel);
        }
        return listnyapopuler;

    }

    private ArrayList<PopulerModel> tambahItemenrekang(){

            datatitlepopuler = getResources().getStringArray(R.array.wisata_enrekang);
            datadeskripsipopuler = getResources().getStringArray(R.array.deskripsi_enrekang);
            dataFotopopuler = getResources().obtainTypedArray(R.array.gambar_enrekang);

        ArrayList<PopulerModel> listnyapopuler = new ArrayList<>();

        for(int i = 0; i < datatitlepopuler.length; i++){
            PopulerModel populerModel = new PopulerModel();
            populerModel.setTitel(datatitlepopuler[i]);
            populerModel.setDeskripsi(datadeskripsipopuler[i]);
            populerModel.setGambar(dataFotopopuler.getResourceId(i, -1));
            listnyapopuler.add(populerModel);
        }
        return listnyapopuler;

    }


    private ArrayList<PopulerModel> tambahItemgowa(){

            datatitlepopuler = getResources().getStringArray(R.array.wisata_gowa);
            datadeskripsipopuler = getResources().getStringArray(R.array.deskripsi_gowa);
            dataFotopopuler = getResources().obtainTypedArray(R.array.gambar_gowa);

        ArrayList<PopulerModel> listnyapopuler = new ArrayList<>();

        for(int i = 0; i < datatitlepopuler.length; i++){
            PopulerModel populerModel = new PopulerModel();
            populerModel.setTitel(datatitlepopuler[i]);
            populerModel.setDeskripsi(datadeskripsipopuler[i]);
            populerModel.setGambar(dataFotopopuler.getResourceId(i, -1));
            listnyapopuler.add(populerModel);
        }
        return listnyapopuler;

    }

    private ArrayList<PopulerModel> tambahItembulukumba(){

            datatitlepopuler = getResources().getStringArray(R.array.wisata_bulukumba);
            datadeskripsipopuler = getResources().getStringArray(R.array.deskripsi_bulukumba);
            dataFotopopuler = getResources().obtainTypedArray(R.array.gambar_bulukumba);

        ArrayList<PopulerModel> listnyapopuler = new ArrayList<>();

        for(int i = 0; i < datatitlepopuler.length; i++){
            PopulerModel populerModel = new PopulerModel();
            populerModel.setTitel(datatitlepopuler[i]);
            populerModel.setDeskripsi(datadeskripsipopuler[i]);
            populerModel.setGambar(dataFotopopuler.getResourceId(i, -1));
            listnyapopuler.add(populerModel);
        }
        return listnyapopuler;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_detail_kota, container, false);

        getname = v.findViewById(R.id.getname);

        KotaDetailActivity kotaDetailActivity = (KotaDetailActivity) getActivity();
        getname.setText(kotaDetailActivity.getDatanamaKota());
        String kota = getname.getText().toString();

        if (kota.equals("MAKASSAR")){
            populerModelArrayList = tambahItemmakassar();
        } else if (kota.equals("GOWA")){
            populerModelArrayList = tambahItemgowa();
        } else if (kota.equals("MAROS")){
            populerModelArrayList = tambahItemmaros();
        } else if (kota.equals("BULUKUMBA")){
            populerModelArrayList = tambahItembulukumba();
        }else if (kota.equals("ENREKANG")){
            populerModelArrayList = tambahItemenrekang();
        }else if (kota.equals("TANA TORAJA")){
            populerModelArrayList = tambahItemtoraja();
        }

        recyclerView = v.findViewById(R.id.rv_detail_kota);
        PopulerAdapter populerAdapter = new PopulerAdapter(getContext(),populerModelArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(populerAdapter);







        return v;
    }




}

package com.example.pasolle.Home;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasolle.Histori.HistoriFragment;
import com.example.pasolle.Home.Populer.PopulerAdapter;
import com.example.pasolle.Home.Populer.PopulerModel;
import com.example.pasolle.Home.PromoHome.PromoHomeAdapter;
import com.example.pasolle.Home.PromoHome.PromoModel;
import com.example.pasolle.Hotel.HotelFragment;
import com.example.pasolle.Kota.KotaFragment;
import com.example.pasolle.Pesawat.PesawatFragment;
import com.example.pasolle.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    View v;
    private String[] datanama;
    private String[] datatitlepopuler;
    private String[] datadeskripsipopuler;
    private TypedArray dataFoto;
    private TypedArray dataFotopopuler;
    private RecyclerView myrecyclerView;
    private RecyclerView recyclerViewpopuler;
    private ArrayList<PromoModel> promoModelArrayList;
    private ArrayList<PopulerModel> populerModelArrayList;
    private HomeFragment mFragments;

    private LinearLayout menu_kota;
    private LinearLayout menu_pesawat;
    private LinearLayout menu_hotel;
    private LinearLayout menu_histori;




    private ArrayList<PromoModel> tambahItem(){

        datanama = getResources().getStringArray(R.array.nama_gambar_promo);
        dataFoto = getResources().obtainTypedArray(R.array.gambar_promo);

        ArrayList<PromoModel> listnya = new ArrayList<>();

        for(int a = 0; a < datanama.length; a++){
            PromoModel promoModel = new PromoModel();
            promoModel.setGambar(dataFoto.getResourceId(a, -1));
            listnya.add(promoModel);
        }
        return listnya;
    }

    private ArrayList<PopulerModel> tambahItempopuler(){

        datatitlepopuler = getResources().getStringArray(R.array.titel_populer);
        datadeskripsipopuler = getResources().getStringArray(R.array.deskripsi_populer);
        dataFotopopuler = getResources().obtainTypedArray(R.array.gambar_populer);

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

    public HomeFragment() {

    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        promoModelArrayList = tambahItem();
        populerModelArrayList = tambahItempopuler();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);


        menu_kota = v.findViewById(R.id.menu_kota);
        menu_hotel = v.findViewById(R.id.menu_hotel);
        menu_pesawat = v.findViewById(R.id.menu_pesawat);
        menu_histori = v.findViewById(R.id.menu_histori);

        myrecyclerView = v.findViewById(R.id.rv_home);
        recyclerViewpopuler = v.findViewById(R.id.rv_populer);

        PromoHomeAdapter promoHomeAdapter = new PromoHomeAdapter(getContext(), promoModelArrayList);
        PopulerAdapter populerAdapter = new PopulerAdapter(getContext(),populerModelArrayList);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewpopuler.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(promoHomeAdapter);
        recyclerViewpopuler.setAdapter(populerAdapter);


        menu_kota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Fragment kotaFragment = new KotaFragment();
               FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.replace(R.id.main_fragment, kotaFragment);
               fragmentTransaction.addToBackStack(null);
               fragmentTransaction.commit();

            }
        });

        menu_histori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment historiFragment = new HistoriFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_fragment, historiFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        menu_pesawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment pesawatFragment = new PesawatFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_fragment, pesawatFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        menu_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment hotelFragment = new HotelFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_fragment, hotelFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });




        return v;
    }



}

package com.example.pasolle.Hotel;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasolle.Kota.KotaModel;
import com.example.pasolle.R;

import java.util.ArrayList;

public class HotelFragment extends Fragment {

    private View v;
    private String[] datanamahotel;
    private String[] dataalamathotel;
    private String[] datahargahotel;
    private TypedArray dataimage1hotel;
    private TypedArray dataimage2hotel;
    private RecyclerView recyclerViewhotel;
    private ArrayList<HotelModal> hotelModalArrayList;

    public HotelFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hotelModalArrayList = tambahItemHotel();
    }


    private ArrayList<HotelModal> tambahItemHotel(){

        datanamahotel = getResources().getStringArray(R.array.nama_hotel);
        dataalamathotel = getResources().getStringArray(R.array.alamat_hotel);
        datahargahotel = getResources().getStringArray(R.array.harga_hotel);
        dataimage1hotel = getResources().obtainTypedArray(R.array.gambar1_hotel);
        dataimage2hotel = getResources().obtainTypedArray(R.array.gambar2_hotel);

        ArrayList<HotelModal> listnyahotel = new ArrayList<>();

        for(int a = 0; a < datanamahotel.length; a++){
            HotelModal hotelModal = new HotelModal();
            hotelModal.setNmaa_hotel(datanamahotel[a]);
            hotelModal.setAlamat_hotel(dataalamathotel[a]);
            hotelModal.setHarga_hotel(datahargahotel[a]);
            hotelModal.setGambar1_hotel(dataimage1hotel.getResourceId(a, -1));
            hotelModal.setGambar2_hotel(dataimage2hotel.getResourceId(a, -1));
            listnyahotel.add(hotelModal);
        }
        return listnyahotel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_hotel, container, false);

        recyclerViewhotel = v.findViewById(R.id.rv_item_hotel);

        CariHotelAdapter cariHotelAdapter = new CariHotelAdapter(getContext(), hotelModalArrayList);
        recyclerViewhotel.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewhotel.setAdapter(cariHotelAdapter);

        return v;
    }
}

package com.example.pasolle.Pesawat.Tujuan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pasolle.R;

import java.util.ArrayList;

public class TujuanPesawatActivity extends Fragment {

    private View v;
    private EditText edit_cari_tujuan;

    private String[] datanamatujuan;
    private RecyclerView rv_cari_tujuan_pesawat;
    private ArrayList<TujuanPesawatModal> tujuanPesawatModals;
    private String data_kode;
    private String data_from;
    private String data_to;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_tujuan_pesawat, container, false);

        edit_cari_tujuan = v.findViewById(R.id.edit_cari_tujuan);


        rv_cari_tujuan_pesawat = v.findViewById(R.id.rv_cari_tujuan_pesawat);
        TujuanPesawatAdapter tujuanPesawatAdapter = new TujuanPesawatAdapter(getContext(), tujuanPesawatModals);
        rv_cari_tujuan_pesawat.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_cari_tujuan_pesawat.setAdapter(tujuanPesawatAdapter);



        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tujuanPesawatModals = tambahdata();



    }

    private ArrayList<TujuanPesawatModal> tambahdata(){

        datanamatujuan = getResources().getStringArray(R.array.tujuan_pesawat);
        Bundle getargument = getArguments();
        if (getargument != null){
            data_kode = getargument.getString("kodetujuan");
            data_from = getargument.getString("from");
            data_to = getargument.getString("to");
        }


        ArrayList<TujuanPesawatModal> listnya = new ArrayList<>();

        if (data_from == null && data_kode == "1" && data_to != null ){
            for (int a=0; a<datanamatujuan.length; a++){
                TujuanPesawatModal tujuanPesawatModal = new TujuanPesawatModal();
                tujuanPesawatModal.setNama_tujuan(data_to);
                tujuanPesawatModal.setKode_maksud(data_kode);
                tujuanPesawatModal.setBandara_dari(datanamatujuan[a]);
                listnya.add(tujuanPesawatModal);
            }
        }else if (data_to == null && data_kode == "2" && data_from != null ){
            for (int a=0; a<datanamatujuan.length; a++){
                TujuanPesawatModal tujuanPesawatModal = new TujuanPesawatModal();
                tujuanPesawatModal.setNama_tujuan(datanamatujuan[a]);
                tujuanPesawatModal.setKode_maksud(data_kode);
                tujuanPesawatModal.setBandara_dari(data_from);
                listnya.add(tujuanPesawatModal);
            }
        } else if (data_to == null && data_kode == "1" && data_from == null  ) {
            for (int a = 0; a < datanamatujuan.length; a++) {
                TujuanPesawatModal tujuanPesawatModal = new TujuanPesawatModal();
                tujuanPesawatModal.setKode_maksud(data_kode);
                tujuanPesawatModal.setBandara_dari(datanamatujuan[a]);
                listnya.add(tujuanPesawatModal);

            }
        } else if (data_to == null && data_kode == "2" && data_from == null  ){
            for (int a = 0; a < datanamatujuan.length; a++) {
                TujuanPesawatModal tujuanPesawatModal = new TujuanPesawatModal();
                tujuanPesawatModal.setKode_maksud(data_kode);
                tujuanPesawatModal.setBandara_tujuan(datanamatujuan[a]);
                listnya.add(tujuanPesawatModal);
            }
        }

        return listnya;
    }
}

package com.example.pasolle.Pesawat;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasolle.Intro.IntroActivity;
import com.example.pasolle.Kota.KotaFragment;
import com.example.pasolle.Kota.KotaModel;
import com.example.pasolle.MainActivity;
import com.example.pasolle.Pesawat.Tujuan.TujuanPesawatActivity;
import com.example.pasolle.Pesawat.Tujuan.TujuanPesawatModal;
import com.example.pasolle.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class PesawatFragment extends Fragment {


    public static final String EXTRA_DATA = "extra_data";
    private View v;
    private EditText pesawat_from;
    private EditText pesawat_to;
    private EditText pesawat_tanggal;

    private LinearLayout pesawat_anim_search;

    private Button btn_min, btn_plus, btn_search_pesawat;
    private TextView tv_orang;

    private String[] datanamapesawat;
    private TypedArray datagambarpesawat;

    private RecyclerView pesawat_rv;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat simpleDateFormat;

    private ArrayList<PesawatModal> pesawatModalArrayList;

    public PesawatFragment(){

    }

    private ArrayList<PesawatModal> tambahItempesawat(){

        datanamapesawat = getResources().getStringArray(R.array.nama_pesawat);
        datagambarpesawat = getResources().obtainTypedArray(R.array.gambar_pesawat);

        ArrayList<PesawatModal> listnyakota = new ArrayList<>();

        for(int a = 0; a < datanamapesawat.length; a++){
            PesawatModal pesawatModal = new PesawatModal();
            pesawatModal.setPesawat_nama(datanamapesawat[a]);
            pesawatModal.setPesawat_gambar(datagambarpesawat.getResourceId(a, -1));
            listnyakota.add(pesawatModal);
        }
        return listnyakota;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pesawatModalArrayList = tambahItempesawat();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_pesawat, container, false);

        pesawat_from = v.findViewById(R.id.pesawat_from);
        pesawat_to = v.findViewById(R.id.pesawat_to);
        pesawat_tanggal = v.findViewById(R.id.pesawat_tanggal);
        tv_orang = v.findViewById(R.id.tv_orang);
        btn_min = v.findViewById(R.id.btn_min);
        btn_plus = v.findViewById(R.id.btn_plus);
        btn_search_pesawat = v.findViewById(R.id.btn_search_pesawat);
        pesawat_anim_search = v.findViewById(R.id.pesawat_anim_search);
        pesawat_rv = v.findViewById(R.id.pesawat_rv);


        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hasiltambah = tv_orang.getText().toString();
                int angka = Integer.parseInt(hasiltambah);
                angka = angka + 1;
                tv_orang.setText(String.valueOf(angka));
            }
        });

        btn_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hasilkurang = tv_orang.getText().toString();
                int angka = Integer.parseInt(hasilkurang);
                angka = angka - 1;
                tv_orang.setText(String.valueOf(angka));
            }
        });

        simpleDateFormat = new SimpleDateFormat("EEEE, dd MMM");
        pesawat_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogTanggal();
            }
        });
        PesawatAdapter pesawatAdapter = new PesawatAdapter(getContext(), pesawatModalArrayList);
        pesawat_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        pesawat_rv.setAdapter(pesawatAdapter);

        btn_search_pesawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dari = pesawat_from.getText().toString();
                String ke = pesawat_to.getText().toString();
                String tgl = pesawat_tanggal.getText().toString();

                if (dari.equals("")|| ke.equals("")|| tgl.equals("")){
                    Toast.makeText(getActivity(), "Lengkapi Data di Atas", Toast.LENGTH_SHORT).show();

                } else{

                pesawat_anim_search.setVisibility(View.GONE);
                pesawat_rv.setVisibility(View.VISIBLE);

                }
            }
        });

//        Bundle bundle = this.getArguments();
//        if (bundle != null){
//            TujuanPesawatModal tujuanPesawatModal = bundle.getParcelable(EXTRA_DATA);
//            pesawat_from.setText(tujuanPesawatModal.getNama_tujuan());
//        }

//        Bundle bundlea = this.getArguments();
//        if (bundlea != null){
//            String to = bundlea.getString("to");
//            String from = bundlea.getString("from");
//            String getkode = bundlea.getString("kode");
//            if (getkode=="1"){
//                pesawat_from.setText(from);
//                pesawat_to.setText(to);
//            } else  if (getkode=="2") {
//                pesawat_to.setText(to);
//                pesawat_from.setText(from);
//            }
//        }


//        pesawat_from.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Fragment tujuanpesatatFragment = new TujuanPesawatActivity();
//                Bundle bundle = new Bundle();
//                bundle.putString("kodetujuan","1");
//                bundle.putString("from",pesawat_from.getText().toString());
//                bundle.putString("to",pesawat_to.getText().toString());
//                tujuanpesatatFragment.setArguments(bundle);
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.main_fragment, tujuanpesatatFragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });
//
//        pesawat_to.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment tujuanpesatatFragment = new TujuanPesawatActivity();
//                Bundle bundle = new Bundle();
//                bundle.putString("kodetujuan","2");
//                bundle.putString("from",pesawat_from.getText().toString());
//                bundle.putString("to",pesawat_to.getText().toString());
//                tujuanpesatatFragment.setArguments(bundle);
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.main_fragment, tujuanpesatatFragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });

        return v;

    }

    private void showDialogTanggal(){
        Calendar mCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Calendar newdate = Calendar.getInstance();
                newdate.set(year, month, day);

                pesawat_tanggal.setText(simpleDateFormat.format(newdate.getTime()));
            }
        },mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

}


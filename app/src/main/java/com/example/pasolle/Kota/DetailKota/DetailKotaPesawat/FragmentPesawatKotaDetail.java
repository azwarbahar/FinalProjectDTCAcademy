package com.example.pasolle.Kota.DetailKota.DetailKotaPesawat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pasolle.Kota.DetailKota.KotaDetailActivity;
import com.example.pasolle.R;

public class FragmentPesawatKotaDetail extends Fragment {
    View v;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_detail_kota, container, false);


        KotaDetailActivity kotaDetailActivity = (KotaDetailActivity) getActivity();

        return v;
    }
}

package com.example.pasolle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pasolle.Home.Populer.PopulerModel;

public class DetailWisataActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";

    private TextView deskripsi_detail_wisata;
    private ImageView toolbar_image_detail;
    private Toolbar detail_toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);


        deskripsi_detail_wisata = findViewById(R.id.deskripsi_detail_wisata);
        toolbar_image_detail = findViewById(R.id.toolbar_image_detail);
        detail_toolbar = findViewById(R.id.detail_toolbar);


        PopulerModel populerModel = getIntent().getParcelableExtra(EXTRA_DATA);
        if (populerModel != null) {

            deskripsi_detail_wisata.setText(populerModel.getDeskripsi());
            detail_toolbar.setTitle(populerModel.getTitel());
            toolbar_image_detail.setImageResource(populerModel.getGambar());
        }


    }



}

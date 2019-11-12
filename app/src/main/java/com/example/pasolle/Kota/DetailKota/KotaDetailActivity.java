package com.example.pasolle.Kota.DetailKota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pasolle.Kota.DetailKota.DetailKotaHotel.FragmentHotelKotaDetail;
import com.example.pasolle.Kota.DetailKota.DetailKotaPesawat.FragmentPesawatKotaDetail;
import com.example.pasolle.Kota.DetailKota.DetailKotaWisata.FragmentWisataKotaDetail;
import com.example.pasolle.Kota.KotaModel;
import com.example.pasolle.R;
import com.google.android.material.tabs.TabLayout;

public class KotaDetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";


    private ImageView kota_detail_toolbar_image;
    private Toolbar kota_detail_toolbar;
    private ViewPager kota_detail_vp;
    private TabLayout kota_detail_tl;
    private String a;
    private KotaDetailPagerAdapter kotaDetailPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kota_detail);

        kota_detail_vp = findViewById(R.id.kota_detail_vp);
        kota_detail_tl = findViewById(R.id.kota_detail_tl);

        kotaDetailPagerAdapter = new KotaDetailPagerAdapter(getSupportFragmentManager());
        kotaDetailPagerAdapter.AddFragment(new FragmentWisataKotaDetail(), "Wisata");
        kotaDetailPagerAdapter.AddFragment(new FragmentPesawatKotaDetail(), "Pesawat");
        kotaDetailPagerAdapter.AddFragment(new FragmentHotelKotaDetail(), "Hotel");
        kota_detail_vp.setAdapter(kotaDetailPagerAdapter);
        kota_detail_tl.setupWithViewPager(kota_detail_vp);

        kota_detail_toolbar_image = findViewById(R.id.kota_detail_toolbar_image);
        kota_detail_toolbar = findViewById(R.id.kota_detail_toolbar);




        KotaModel kotaModel = getIntent().getParcelableExtra(EXTRA_DATA);


            kota_detail_toolbar_image.setImageResource(kotaModel.getImage_kota());
            kota_detail_toolbar.setTitle(kotaModel.getTitle_kota());


        FragmentWisataKotaDetail fragmentWisataKotaDetail = new FragmentWisataKotaDetail();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("nama_kota",kotaModel.getTitle_kota());
        fragmentWisataKotaDetail.setArguments(bundle);

        fragmentTransaction.replace(R.id.kota_detail_vp, fragmentWisataKotaDetail);

        fragmentTransaction.commit();



//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentWisataKotaDetail fragmentWisataKotaDetail = new FragmentWisataKotaDetail();
//        Bundle bundle = new Bundle();
//        bundle.putString("nama_kota", String.valueOf(kota_detail_toolbar.getTitle()));
//        fragmentWisataKotaDetail.setArguments(bundle);
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.frkota, fragmentWisataKotaDetail);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();



//
//        FragmentPesawatKotaDetail fragmentPesawatKotaDetail = new FragmentPesawatKotaDetail();
//        Bundle bundle1 = new Bundle();
//        bundle1.putString("nama_kota", String.valueOf(kota_detail_toolbar.getTitle()));
//        fragmentWisataKotaDetail.setArguments(bundle1);

        Toast.makeText(this, kota_detail_toolbar.getTitle(), Toast.LENGTH_SHORT).show();
    }

    public String getDatanamaKota(){

        a =kota_detail_toolbar.getTitle().toString();

        return a;
    }
}

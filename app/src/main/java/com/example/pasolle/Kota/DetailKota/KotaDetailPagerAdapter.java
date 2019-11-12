package com.example.pasolle.Kota.DetailKota;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class KotaDetailPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> listfragmentdetailkota = new ArrayList<>();
    private final List<String>listtitledetailkota = new ArrayList<>();

    public KotaDetailPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listfragmentdetailkota.get(position);
    }

    @Override
    public int getCount() {
        return listtitledetailkota.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listtitledetailkota.get(position);
    }

    public void AddFragment(Fragment fragment, String title){
        listfragmentdetailkota.add(fragment);
        listtitledetailkota.add(title);
    }
}

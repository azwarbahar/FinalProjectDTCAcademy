package com.example.pasolle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.pasolle.Histori.HistoriFragment;
import com.example.pasolle.Home.HomeFragment;
import com.example.pasolle.Hotel.HotelFragment;
import com.example.pasolle.Kota.KotaFragment;
import com.example.pasolle.Pesawat.PesawatFragment;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ResideMenu resideMenu;
    private Context mContext;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemHotel;
    private ResideMenuItem itemKota;
    private ResideMenuItem itemPesawat;
    private ResideMenuItem itemHistori;
    private ResideMenuItem itemsetting;
    private ResideMenuItem itemabout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mContext = this;

        setUpMenu();
        changeFragment(new HomeFragment());

    }

    @SuppressLint("ResourceAsColor")
    private void setUpMenu() {

        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.bg_residemenu);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        resideMenu.setScaleValue(0.6f);
        resideMenu.setSwipeDirectionDisable(0);
        resideMenu.setSwipeDirectionDisable(1);



        itemHome     = new ResideMenuItem(this, R.drawable.ic_home, "  Home");
        itemHotel  = new ResideMenuItem(this, R.drawable.ic_hotel,  "  Hotel");
        itemKota = new ResideMenuItem(this, R.drawable.ic_account_balance, "  Kota");
        itemPesawat = new ResideMenuItem(this, R.drawable.ic_flight, "  Pesawat");
        itemHistori = new ResideMenuItem(this, R.drawable.ic_local_library, "  Histori");
        itemsetting = new ResideMenuItem(this, R.drawable.ic_settings, "  Setting");
        itemabout = new ResideMenuItem(this, R.drawable.ic_info, "  About");


        itemHome.setOnClickListener(this);
        itemHotel.setOnClickListener(this);
        itemKota.setOnClickListener(this);
        itemPesawat.setOnClickListener(this);
        itemHistori.setOnClickListener(this);

        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemHotel, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemKota, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemPesawat, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemHistori, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemsetting, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemabout, ResideMenu.DIRECTION_RIGHT);


        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }



    @Override
    public void onClick(View view) {

        if (view == itemHome){
            changeFragment(new HomeFragment());
        }else if (view == itemHotel){
            changeFragment(new HotelFragment());
        }else if (view == itemKota){
            changeFragment(new KotaFragment());
        }else if (view == itemPesawat){
            changeFragment(new PesawatFragment());
        }else if (view == itemHistori){
            changeFragment(new HistoriFragment());
        }else if (view == itemsetting){
            changeFragment(new HistoriFragment());
        }else if (view == itemabout){
            changeFragment(new HistoriFragment());
        }

        resideMenu.closeMenu();

    }


    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu(){
        return resideMenu;
    }
}

package com.example.pasolle.Intro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.pasolle.R;

public class IntroAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public IntroAdapter(Context context) {
        this.context = context;
    }


    //Gambar
    public int[] slide_gambar = {
            R.drawable.slider1,
            R.drawable.slider2,
            R.drawable.slider3
    };

    //judul
    public String[] slide_judul = {
            "TUJUAN",
            "PILIHAN TANGGAL",
            "MENDAPATKAN TIKET ANDA"
    };

    public String[] slide_desk = {

            "Memesan penerbangan dan menginap di Hotel di dekat lokasi perjalanan Anda",
            "Memilih waktu yang tepat untuk perjalanan Anda baik dengan seseorang atau sendirian",
            "Menemukan tempat paling populer, atau menemukan Tempat apa yang Anda inginkan"

    };


    @Override
    public int getCount() {
        return slide_judul.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.intro_1, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView1 = view.findViewById(R.id.textView);
        TextView textView2 = view.findViewById(R.id.textView2);

        imageView.setImageResource(slide_gambar[position]);
        textView1.setText(slide_judul[position]);
        textView2.setText(slide_desk[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}

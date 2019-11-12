package com.example.pasolle.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pasolle.MainActivity;
import com.example.pasolle.R;

public class IntroActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private IntroAdapter introAdapter;

    private TextView[] mDots;

    private TextView btnlanjut;
    private int halamanskarang;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        linearLayout = findViewById(R.id.linearlayout);
        viewPager = findViewById(R.id.viewPager);
        btnlanjut = findViewById(R.id.btn_lanjut);

        introAdapter = new IntroAdapter(this);
        viewPager.setAdapter(introAdapter);
        tambahdotsIndicator(0);

        viewPager.addOnPageChangeListener(viewlistener);

        btnlanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void tambahdotsIndicator(int position){
        mDots = new TextView[3];
        linearLayout.removeAllViews();
        for (int i = 0; i<mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.putih));

            linearLayout.addView(mDots[i]);
        }

        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorutama));
        }

    }
    ViewPager.OnPageChangeListener viewlistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            tambahdotsIndicator(position);
            halamanskarang = position;

            if (position == 0){

                btnlanjut.setEnabled(true);


                btnlanjut.setText("Skip");


            } else if (position == mDots.length - 1){
                btnlanjut.setEnabled(true);


                btnlanjut.setText("Done");

            }
            else {
                btnlanjut.setEnabled(true);


                btnlanjut.setText("Skip");

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}

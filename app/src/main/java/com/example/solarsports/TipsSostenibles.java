package com.example.solarsports;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import com.bumptech.glide.Glide;

public class TipsSostenibles extends BaseActivity
{
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_sostenibles);
        setupNavigationBar();
        setupTopBar();


        viewFlipper = findViewById(R.id.viewFlipper);

        loadGIFs();

        viewFlipper.setFlipInterval(10000);
        viewFlipper.startFlipping();
    }

    private void loadGIFs()
    {
        ImageView tip1Image = findViewById(R.id.tip1_image);
        ImageView tip2Image = findViewById(R.id.tip2_image);
        ImageView tip3Image = findViewById(R.id.tip4_image);

        Glide.with(this)
                .asGif()
                .load(R.drawable.tip1)
                .into(tip1Image);

        Glide.with(this)
                .asGif()
                .load(R.drawable.tip2)
                .into(tip2Image);

        Glide.with(this)
                .asGif()
                .load(R.drawable.tip4)
                .into(tip3Image);
    }
}
package com.example.solarsports;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import com.bumptech.glide.Glide;

public class AliadosDirectorio extends BaseActivity
{
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aliados_directorio);
        setupNavigationBar();
        setupTopBar();


        viewFlipper = findViewById(R.id.viewFlipper);

        loadGIFs();

        viewFlipper.setFlipInterval(10000);
        viewFlipper.startFlipping();
    }

    private void loadGIFs()
    {

    }
}
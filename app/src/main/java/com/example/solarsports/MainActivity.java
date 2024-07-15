package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    private static final int tiempoDeCargaPantalla = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(MainActivity.this, InicioSesion.class);
                startActivity(intent);
                finish();
            }
        }, tiempoDeCargaPantalla);
    }
}
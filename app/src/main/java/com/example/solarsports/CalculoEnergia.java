package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CalculoEnergia extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_energia);

        ImageView imageViewArrow = findViewById(R.id.arrowLeft);
        imageViewArrow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CalculoEnergia.this, CalculoPaneles.class);
                startActivity(intent);
            }
        });

        ImageView imageViewlogout = findViewById(R.id.button);
        imageViewlogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CalculoEnergia.this, InicioSesion.class);
                startActivity(intent);
            }
        });
    }
}
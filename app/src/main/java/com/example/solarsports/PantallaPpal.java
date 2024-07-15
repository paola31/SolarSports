package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PantallaPpal extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_ppal);

        Button button = findViewById(R.id.calculoPaneles);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(PantallaPpal.this, CalculoPaneles.class);
                startActivity(intent);
            }
        });

        ImageView imageViewLogout = findViewById(R.id.button);
        imageViewLogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(PantallaPpal.this, InicioSesion.class);
                startActivity(intent);
            }
        });

        Button buttonEnergia = findViewById(R.id.calculoEnergia);
        buttonEnergia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(PantallaPpal.this, CalculoEnergia.class);
                startActivity(intent);
            }
        });

        Button ventaEnergia = findViewById(R.id.ventaEnergia);
        ventaEnergia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(PantallaPpal.this, VentaEnergia.class);
                startActivity(intent);
            }
        });


        Button buttontips = findViewById(R.id.tipSostenibles);
        buttontips.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(PantallaPpal.this, TipsSostenibles.class);
                startActivity(intent);
            }
        });

    }
}
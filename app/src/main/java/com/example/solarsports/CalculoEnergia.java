package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculoEnergia extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_energia);


        TextView textViewEstadiscticas = findViewById(R.id.verEstadisticas);
        SpannableString estadisticasContent = new SpannableString("Ver estadisticas");
        estadisticasContent.setSpan(new UnderlineSpan(), 0, estadisticasContent.length(),0);
        textViewEstadiscticas.setText(estadisticasContent);

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

        TextView TextEstadisticas = findViewById(R.id.verEstadisticas);
        TextEstadisticas.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CalculoEnergia.this, Estadisticas.class);
                startActivity(intent);
            }
        });
    }
}
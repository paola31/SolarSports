package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VentaEnergia extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_energia);

        ImageView imageViewArrow = findViewById(R.id.arrowLeft);
        imageViewArrow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(VentaEnergia.this, Estadisticas.class);
                startActivity(intent);
            }
        });

        TextView textViewCalcular = findViewById(R.id.textoSolicitar);
        SpannableString calcularContent = new SpannableString("Solicitalo aquí");
        calcularContent.setSpan(new UnderlineSpan(), 0, calcularContent.length(),0);
        textViewCalcular.setText(calcularContent);
    }
}
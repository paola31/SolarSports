package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class CalculoPaneles extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_paneles);

        Spinner spinner = findViewById(R.id.opciones);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinnner_options, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter(adapter);
        spinner.setSelection(0, false);

        TextView textViewCalcular = findViewById(R.id.calcular);
        SpannableString calcularContent = new SpannableString("Calcular");
        calcularContent.setSpan(new UnderlineSpan(), 0, calcularContent.length(),0);
        textViewCalcular.setText(calcularContent);

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
                Intent intent = new Intent(CalculoPaneles.this, PantallaPpal.class);
                startActivity(intent);
            }
        });

        ImageView imageViewEstadisticas = findViewById(R.id.iconoEstadistcias);
        imageViewEstadisticas.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CalculoPaneles.this, Estadisticas.class);
                startActivity(intent);
            }
        });

        ImageView imageViewlogout = findViewById(R.id.button);
        imageViewlogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CalculoPaneles.this, InicioSesion.class);
                startActivity(intent);
            }
        });
     }
}

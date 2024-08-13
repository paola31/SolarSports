package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class CalculoEnergia extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_energia);
        setupNavigationBar();

        EditText latitud = findViewById(R.id.latitudDato);
        EditText longitud = findViewById(R.id.longitudDato);
        EditText inclinacion = findViewById(R.id.inclinacionDato);
        EditText cantidadPaneles = findViewById(R.id.cantidadPanelesDato);
        TextView energiaGenerada = findViewById(R.id.energiaGenerada);
        TextView calcularEnergia = findViewById(R.id.calcularEnergia);

        calcularEnergia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Double latidudValue = Double.parseDouble(latitud.getText().toString());
                Double longitudValue = Double.parseDouble(longitud.getText().toString());
                int inclinacionValue = Integer.parseInt(inclinacion.getText().toString());
                int cantidadPanelesValues = Integer.parseInt(cantidadPaneles.getText().toString());

                double energia = calcularProduccionEnergia(latidudValue, longitudValue, cantidadPanelesValues, inclinacionValue);

                BigDecimal energiaAcotada = new BigDecimal(energia).setScale(2, RoundingMode.HALF_UP);
                energiaGenerada.setText(energiaAcotada + " Kw / Dia");
            }
        });

        TextView textViewEstadiscticas = findViewById(R.id.verEstadisticas);
        SpannableString estadisticasContent = new SpannableString("Ver estadisticas");
        estadisticasContent.setSpan(new UnderlineSpan(), 0, estadisticasContent.length(),0);
        textViewEstadiscticas.setText(estadisticasContent);

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

    private double calcularProduccionEnergia(double latitud, double longitud, int numeroPaneles, int inclinacion)
    {
        double area = numeroPaneles * 1.7;
        double latitudRad = Math.toRadians(latitud);
        double longitudRad = Math.toRadians(longitud);
        double inclinacionRad = Math.toRadians(inclinacion);
        double produccionEnergia = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int diaDeAnio = LocalDate.now().getDayOfYear();

            double anguloIncidencia = Math.acos(Math.sin(latitudRad) * Math.sin(inclinacionRad) * Math.cos(inclinacionRad));

            double constanteSolar = 0.1367;
            double radiacion = constanteSolar * Math.cos(anguloIncidencia) * (1 + 0.033 * Math.cos(Math.toRadians(360 * diaDeAnio / 360)));

            double eficienciaPanel = 0.16;
            double factorPerdidas = 0.9;
            produccionEnergia = area * radiacion * eficienciaPanel * factorPerdidas;

        }

        return produccionEnergia * 100;
    }
}
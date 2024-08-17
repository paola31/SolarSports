package com.example.solarsports;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalculoEnergia extends BaseActivity
{
    EditText latitud;
    EditText longitud;
    EditText inclinacion;
    EditText cantidadPaneles;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_energia);
        setupNavigationBar();
        setupTopBar();

        latitud = findViewById(R.id.latitudDato);
        longitud = findViewById(R.id.longitudDato);
        inclinacion = findViewById(R.id.inclinacionDato);
        cantidadPaneles = findViewById(R.id.cantidadPanelesDato);
        TextView energiaGenerada = findViewById(R.id.energiaGenerada);
        TextView calcularEnergia = findViewById(R.id.calcularEnergia);
        ImageView iconCasa = findViewById(R.id.iconCasa);
        calcularEnergia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!isFormatValid())
                {
                    Toast.makeText(CalculoEnergia.this, "Todos los campos deden estar dilegenciados", Toast.LENGTH_LONG).show();
                    return;
                }
                String latitudString = latitud.getText().toString();
                latitudString = latitudString.isEmpty() ? "20" : latitudString;
                Double latidudValue = Double.parseDouble(latitudString);

                Double longitudValue = Double.parseDouble(longitud.getText().toString());
                int inclinacionValue = Integer.parseInt(inclinacion.getText().toString());
                int cantidadPanelesValues = Integer.parseInt(cantidadPaneles.getText().toString());

                double energia = calcularProduccionEnergia(latidudValue, longitudValue, cantidadPanelesValues, inclinacionValue);

                BigDecimal energiaAcotada = new BigDecimal(energia).setScale(2, RoundingMode.HALF_UP);
                energiaGenerada.setText(energiaAcotada + " Kw / Dia");

                iconCasa.setVisibility(View.VISIBLE);
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

    private boolean isFormatValid()
    {
        boolean isValid = true;
        String erroresValidacion = "";

        String latitudInt = latitud.getText().toString();
        String longitudInt = longitud.getText().toString();
        String inclinacionInt = inclinacion.getText().toString();
        String cantidadPanelesInt = cantidadPaneles.getText().toString();

        if (latitudInt.isEmpty() || longitudInt.isEmpty() || inclinacionInt.isEmpty() || cantidadPanelesInt.isEmpty())
        {
            erroresValidacion += "Todos los campos deben contener un valor. ";
            isValid  =false;
        }

        return  isValid;
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


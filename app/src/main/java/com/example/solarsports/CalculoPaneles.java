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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculoPaneles extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_paneles);
        setupNavigationBar();

        Spinner spinner = findViewById(R.id.opciones);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinnner_options, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter(adapter);
        spinner.setSelection(0, false);

        EditText hps = findViewById(R.id.hps);
        EditText consumoEnergia = findViewById(R.id.consumoEnergia);

        TextView resultado = findViewById(R.id.cantidadPaneles);

        TextView textViewCalcular = findViewById(R.id.calcular);
        SpannableString calcularContent = new SpannableString("Calcular");
        calcularContent.setSpan(new UnderlineSpan(), 0, calcularContent.length(),0);
        textViewCalcular.setText(calcularContent);


        textViewCalcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String tipoPanel = spinner.getSelectedItem().toString();

                if(tipoPanel.equals("Seleccionar"))
                {
                    Toast.makeText(CalculoPaneles.this, "Debes seleccionar el tipo de panel", Toast.LENGTH_LONG).show();
                    return;
                }

                String hpsValue = hps.getText().toString();
                String consumoEnergiaValue = consumoEnergia.getText().toString();

                Double potencia = TipoPanel.obtenerValorPorDescripcion(tipoPanel);
                Double energiaPanelDiaria = potencia * Double.parseDouble(hpsValue);

                Double cantidadPanelesAprox = Double.parseDouble(consumoEnergiaValue) / energiaPanelDiaria;
                int cantidadPaneles = (int) Math.ceil(cantidadPanelesAprox);

                resultado.setText(cantidadPaneles + " Paneles");
            }
        });
    }
}
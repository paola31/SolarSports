package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
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
        SpannableString content = new SpannableString("Calcular");
        content.setSpan(new UnderlineSpan(), 0, content.length(),0);
        textViewCalcular.setText(content);

    }
}
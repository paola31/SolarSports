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
import android.widget.Toast;

public class VentaEnergia extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_energia);
        setupNavigationBar();
        setupTopBar();

        EditText nombreCompleto = findViewById(R.id.nombre);
        EditText correo = findViewById(R.id.correo);
        EditText energiaExtra = findViewById(R.id.cantidadEnergia);

        TextView textViewSolicitar = findViewById(R.id.textoSolicitar);
        SpannableString solicitarContent = new SpannableString("Solicitalo aquí");
        solicitarContent.setSpan(new UnderlineSpan(), 0, solicitarContent.length(),0);
        textViewSolicitar.setText(solicitarContent);

        textViewSolicitar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String nombre = nombreCompleto.getText().toString();
                String correoElectronico = correo.getText().toString();
                String energia = energiaExtra.getText().toString();

                if (nombre.isEmpty() || correoElectronico.isEmpty() || energia.isEmpty())
                {
                    Toast.makeText(VentaEnergia.this, "Por favor complete todos los campos", Toast.LENGTH_LONG).show();
                    return;
                }

                String mensaje = "Hola " + nombre + ", la información fue enviada a " + correoElectronico;

                Toast.makeText(VentaEnergia.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
}
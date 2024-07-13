package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class InicioSesion extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        TextView textView = findViewById(R.id.olvidasteContraseña);
        textView.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v)
            {
                Intent intent = new Intent(InicioSesion.this, RecuperarContrasena.class);
                startActivity(intent);
            }
        });

        TextView textViewRegistrate = findViewById(R.id.registrate);
        textViewRegistrate.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v)
            {
                Intent intent = new Intent(InicioSesion.this, Registro.class);
                startActivity(intent);
            }
        });

        ImageButton imageButtonlogin = findViewById(R.id.login_Sesion);
        imageButtonlogin.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v)
            {
                Intent intent = new Intent(InicioSesion.this, PantallaPpal.class);
                startActivity(intent);
            }
        });
    }
}


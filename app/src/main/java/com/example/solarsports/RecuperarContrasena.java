package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class RecuperarContrasena extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena);

        ImageButton logoutButton = findViewById(R.id.logOut);
        logoutButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(RecuperarContrasena.this, InicioSesion.class);
                startActivity(intent);
            }
        });

        ImageButton loginButton = findViewById(R.id.login_Recuper);
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(RecuperarContrasena.this, InicioSesion.class);
                startActivity(intent);
            }
        });
    }
}

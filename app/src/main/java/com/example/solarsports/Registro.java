package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Registro extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ImageButton loginButton = findViewById(R.id.login_Recuper);
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Registro.this, InicioSesion.class);
                startActivity(intent);
            }
        });

        ImageButton logoutButton = findViewById(R.id.logOutResgistro);
        logoutButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Registro.this, InicioSesion.class);
                startActivity(intent);
            }
        });
    }
}
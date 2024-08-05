package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Registro extends AppCompatActivity
{
    private EditText correo, contraseñaRegistro;
    private CheckBox terminosCondiciones;
    private ImageButton login_Registro;

    private UserManager userManager;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        /*correo = findViewById(R.id.correo);
        contraseñaRegistro = findViewById(R.id.contraseñaRegistro);
        terminosCondiciones = findViewById(R.id.terminosCondiciones);
        login_Registro = findViewById(R.id.login_Registro);

        userManager = new UserManager(this);

        login_Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });*/


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
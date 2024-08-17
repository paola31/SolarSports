package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecuperarContrasena extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena);

        TextView textViewCalcular = findViewById(R.id.enviarCodigo);
        SpannableString content = new SpannableString("Enviar código");
        content.setSpan(new UnderlineSpan(), 0, content.length(),0);
        textViewCalcular.setText(content);

        textViewCalcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(RecuperarContrasena.this, "Código enviado a tu correo", Toast.LENGTH_LONG).show();
            }
        });

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
                Intent intent = new Intent(RecuperarContrasena.this, RecuperarContrasenaConf.class);
                startActivity(intent);
            }
        });
    }
}

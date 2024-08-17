package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import javax.xml.transform.sax.SAXResult;

public class RecuperarContrasenaConf extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena_conf);

        ImageButton loginButton = findViewById(R.id.login_Recuper);
        EditText nuevaContrasena = findViewById(R.id.nuevaContraseña);
        EditText confContrasena = findViewById(R.id.ConfirmarContraseña);
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String nuevaContrasenaText = nuevaContrasena.getText().toString();
                String confContrasenaText = confContrasena.getText().toString();

                if (!nuevaContrasenaText.equals(confContrasenaText))
                {
                    Toast.makeText(RecuperarContrasenaConf.this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();

                    nuevaContrasena.setText("");
                    confContrasena.setText("");

                    return;
                }
                else
                    Toast.makeText(RecuperarContrasenaConf.this, "Contraseña modificada con éxito", Toast.LENGTH_LONG).show();


                Intent intent = new Intent(RecuperarContrasenaConf.this, InicioSesion.class);
                startActivity(intent);
            }
        });
    }
}



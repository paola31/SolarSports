package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity
{
    private EditText correo;
    private EditText contraseña;
    private String valorCorreo;
    private String valorContraseña;
    private UserSessionManager userManager;
    private String erroresValidacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        correo = findViewById(R.id.nombreOusuario);
        contraseña = findViewById(R.id.contraseña);
        userManager = new UserSessionManager(this);

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
                valorCorreo = correo.getText().toString();
                valorContraseña = contraseña.getText().toString();
                if(isFormValid())
                {
                    if(userManager.loginUser(valorCorreo, valorContraseña))
                    {
                        Intent intent = new Intent(InicioSesion.this, PantallaPpal.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(InicioSesion.this, "Usuario o contraseña invalidos", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(InicioSesion.this, erroresValidacion, Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private boolean isFormValid()
    {
        boolean isValid = true;
        erroresValidacion = "";

        if(valorCorreo.isEmpty() || valorContraseña.isEmpty())
        {
            erroresValidacion = erroresValidacion + "Ambos campos son obligatorios"  + "\n";
            isValid = false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(valorCorreo).matches())
        {
            erroresValidacion = erroresValidacion + "El correo no es valido"  + "\n";
            isValid = false;
        }


        return  isValid;
    }
}
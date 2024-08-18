package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.util.Patterns;
import android.widget.Toast;

public class Registro extends AppCompatActivity
{
    private EditText correo;
    private EditText nombre;
    private EditText contraseñaRegistro;
    private EditText confirmarContraseña;
    private CheckBox terminosCondiciones;
    private CheckBox tratamientoDatos;
    private ImageButton login_Registro;
    private String erroresValidacion = "";

    private DataManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.nombreCompleto);
        correo = findViewById(R.id.correo);
        contraseñaRegistro = findViewById(R.id.contraseñaRegistro);
        confirmarContraseña = findViewById(R.id.ConfirmarContraseñaRegis);
        terminosCondiciones = findViewById(R.id.terminosCondiciones);
        tratamientoDatos = findViewById(R.id.tratamientoDatos);
        login_Registro = findViewById(R.id.registrar);

        userManager = new DataManager(this);

        login_Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if(isFormValid())
                {
                    userManager.registerUser(correo.getText().toString(), contraseñaRegistro.getText().toString(), nombre.getText().toString());
                    Toast.makeText(Registro.this, "Registro exitoso", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Registro.this, InicioSesion.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Registro.this, erroresValidacion, Toast.LENGTH_LONG).show();
                }
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


    private boolean isFormValid()
    {
        boolean isValid = true;
        erroresValidacion = "";
        String valorNombre = nombre.getText().toString();
        String contraseña = contraseñaRegistro.getText().toString();
        String confirmacion = confirmarContraseña.getText().toString();
        String direccionCorreo = correo.getText().toString();

        if(valorNombre.isEmpty() || contraseña.isEmpty() || confirmacion.isEmpty() || direccionCorreo.isEmpty())
        {
            erroresValidacion = erroresValidacion + "Ningun campo puede estar vacio" + "\n";
            isValid = false;
        }

        if(!contraseña.equals(confirmacion))
        {
            erroresValidacion = erroresValidacion + "Las contraseñas no coindicen" + "\n";
            isValid = false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(direccionCorreo).matches())
        {
            erroresValidacion = erroresValidacion + "El correo no es valido"  + "\n";
            isValid = false;
        }

        if(!terminosCondiciones.isChecked() || !tratamientoDatos.isChecked())
        {
            erroresValidacion = erroresValidacion + "Debe aceptar los terminos y condiciones y el tratamiento de datos"  + "\n";
            isValid = false;
        }

        return isValid;
    }
}
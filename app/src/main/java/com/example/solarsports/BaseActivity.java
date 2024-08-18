package com.example.solarsports;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BaseActivity extends AppCompatActivity
{
    DataManager userManager;

    protected void setupNavigationBar()
    {
        ImageView buttonHome = findViewById(R.id.buttonHome);
        ImageView buttonLogout = findViewById(R.id.buttonLogout);

        if (buttonHome != null) {
            buttonHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(BaseActivity.this, PantallaPpal.class);
                    startActivity(intent);
                }
            });
        }

        if (buttonLogout != null) {
            buttonLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(BaseActivity.this, InicioSesion.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }

    protected void setupTopBar()
    {
        userManager = new DataManager(this);
        TextView nombreUsuario = findViewById(R.id.nombreUsuario);
        nombreUsuario.setText("Bienvenid@, " + userManager.getName());

        TextView fechaActual = findViewById(R.id.fecha);  // Asegúrate de que este ID exista en tu layout

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            LocalDate fecha = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd/MM/yyyy");
            String fechaFormateada = fecha.format(formatter);

            String resultado = "Hoy, " + fechaFormateada;

            fechaActual.setText(resultado);
        }
    }


}

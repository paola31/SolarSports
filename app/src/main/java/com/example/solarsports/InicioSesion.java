package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


public class InicioSesion extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
    }

    boolean inicioSesion (view:View)
    {
        var texto = onCreatePanelView().getContentDescription()
    }
}

package com.example.solarsports;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity
{
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
}

package com.example.solarsports;

import android.content.SharedPreferences;
import android.content.Context;

public class DataManager
{
    private static final String PREF_NAME = "UserPrefs";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_NAME = "userName";
    public static final String KEY_LATITUD = "latitud";
    public static final String KEY_LONGITUD = "longitud";
    public static final String KEY_INCLINACION = "inclinacion";
    public static final String KEY_PANELES = "paneles";


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public DataManager(Context context)
    {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void registerUser(String email, String password, String name)
    {
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_NAME, name);
        editor.apply();
    }

    public void persistEnergyValues(Float latitud, Float longitud, int inclinacion, int paneles)
    {
        editor.putFloat(KEY_LATITUD, latitud);
        editor.putFloat(KEY_LONGITUD, longitud);
        editor.putInt(KEY_INCLINACION, inclinacion);
        editor.putInt(KEY_PANELES, paneles);
        editor.apply();
    }

    public float getFloatValue(String key)
    {
        return sharedPreferences.getFloat(key, 0.0f);
    }

    public int getIntValue(String key)
    {
        return sharedPreferences.getInt(key, 0);
    }

    public boolean loginUser(String email, String password)
    {
        String registeredEmail = sharedPreferences.getString(KEY_EMAIL, null);
        String registeredPassword = sharedPreferences.getString(KEY_PASSWORD, null);

        return email.equals(registeredEmail) && password.equals(registeredPassword);
    }

    public String getName()
    {
        return sharedPreferences.getString(KEY_NAME, "Usuario");
    }
}
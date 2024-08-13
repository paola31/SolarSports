package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity
{
    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        ImageView regresarButton = findViewById(R.id.button);
        regresarButton.setOnClickListener(view -> finish());

        lineChart = findViewById(R.id.lineChart);
        setupLineChart();
        loadChartData();

        ImageView imageViewArrow = findViewById(R.id.arrowLeft);
        imageViewArrow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Estadisticas.this, CalculoEnergia.class);
                startActivity(intent);
            }
        });

        ImageView imageViewlogout = findViewById(R.id.button);
        imageViewlogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Estadisticas.this, InicioSesion.class);
                startActivity(intent);
            }
        });

    }


    private void setupLineChart()
    {
        lineChart.getDescription().setEnabled(false);
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(getMonths()));

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setAxisMinimum(0f);

        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);
    }

    private void loadChartData() {
        ArrayList<Entry> entries = new ArrayList<>();
        float[] energyProduction = {500, 600, 750, 800, 950, 1100, 1250, 1400, 1550, 1700, 1850, 2000};

        for (int i = 0; i < energyProduction.length; i++) {
            entries.add(new Entry(i, energyProduction[i]));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Producción de Energía (kWh)");
        dataSet.setColor(getResources().getColor(R.color.purple_200));
        dataSet.setValueTextColor(getResources().getColor(R.color.white));

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    private ArrayList<String> getMonths() {
        ArrayList<String> months = new ArrayList<>();
        months.add("Ene");
        months.add("Feb");
        months.add("Mar");
        months.add("Abr");
        months.add("May");
        months.add("Jun");
        months.add("Jul");
        months.add("Ago");
        months.add("Sep");
        months.add("Oct");
        months.add("Nov");
        months.add("Dic");
        return months;
    }
}
package com.example.solarsports;

import com.bumptech.glide.Glide;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Estadisticas extends BaseActivity
{
    private TextView dailyMoney;
    private TextView anualMoney;
    private HorizontalBarChart barChart;
    private Integer money;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        dataManager = new DataManager(this);
        setContentView(R.layout.activity_estadisticas);
        setupTopBar();
        setupNavigationBar();
        barChart = findViewById(R.id.barChart);
        setupBarChart();
        loadChartData();
        setAverageMoney();
        loadGIFs();
    }

    private void setupBarChart()
    {
        barChart.getDescription().setEnabled(false);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(getMonths().size());
        xAxis.setValueFormatter(new IndexAxisValueFormatter(getMonths()));
        xAxis.setTextColor(getResources().getColor(R.color.axis));

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setAxisMinimum(0f);
        leftAxis.setTextColor(getResources().getColor(R.color.axis));
        YAxis rightAxis = barChart.getAxisRight();

        rightAxis.setEnabled(false);
    }

    private void loadGIFs()
    {
        ImageView Image1 = findViewById(R.id.greenli);

        Glide.with(this)
                .asGif()
                .load(R.drawable.greenli)
                .into(Image1);
    }

    private void setAverageMoney()
    {
        dailyMoney = findViewById(R.id.moneyDiario);
        anualMoney = findViewById(R.id.moneyAnual);
        float[] energyProduction = new float[360];

        for(int i=0; i<360; i++)
        {
            energyProduction[i] = this.calcularProduccionEnergia(i);
        }
        float sum = 0;

        for(int i=0; i<energyProduction.length; i++)
        {
            float valorDia = (energyProduction[i]) * 700;
            sum = sum + valorDia;
        }

        float promedio = sum / 360;
        String resultado = " $" + promedio;
        dailyMoney.setText(resultado);

        resultado = " $" + sum;
        anualMoney.setText(" " + resultado);

    }

    private void loadChartData()
    {
        int[] days = {15, 45, 74, 105, 135, 166, 196, 227, 258, 288, 319, 349};
        float[] energyProduction = new float[days.length];

        for(int i=0; i<days.length; i++)
        {
            energyProduction[i] = this.calcularProduccionEnergia(days[i]);
        }

        ArrayList<BarEntry> entries = new ArrayList<>();
        float maxValue = Float.MIN_VALUE;
        float minValue = Float.MAX_VALUE;
        int maxIndex = -1;
        int minIndex = -1;
        float sum = 0;

        for (int i=0; i<energyProduction.length; i++)
        {
            float value = energyProduction[i];
            entries.add(new BarEntry(i, value));

            if (value > maxValue)
            {
                maxValue = value;
                maxIndex = i;
            }

            if (value < minValue)
            {
                minValue = value;
                minIndex = i;
            }
        }

        BarDataSet dataSet = new BarDataSet(entries, "Producción de Energía (kWh)");
        ArrayList<Integer> colors = new ArrayList<>();

        for (int i = 0; i < entries.size(); i++)
        {
            if (i == maxIndex)
            {
                colors.add(getResources().getColor(R.color.custom_max));
            }
            else if (i == minIndex)
            {
                colors.add(getResources().getColor(R.color.custom_min));
            }
            else
            {
                colors.add(getResources().getColor(R.color.purple_200));
            }
        }

        dataSet.setColors(colors);

        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.9f);
        barChart.setData(barData);
        barChart.setFitBars(true);
        barChart.invalidate();
    }


    private float calcularProduccionEnergia(int dia)
    {
        float latitud = dataManager.getFloatValue(DataManager.KEY_LATITUD);
        float longitud = dataManager.getFloatValue(DataManager.KEY_LONGITUD);
        int numeroPaneles = dataManager.getIntValue(DataManager.KEY_PANELES);
        int inclinacion = dataManager.getIntValue(DataManager.KEY_INCLINACION);

        double area = numeroPaneles * 1.7;
        double latitudRad = Math.toRadians(latitud);
        double longitudRad = Math.toRadians(longitud);
        double inclinacionRad = Math.toRadians(inclinacion);
        double produccionEnergia = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            double anguloIncidencia = Math.acos(Math.sin(latitudRad) * Math.sin(inclinacionRad) * Math.cos(inclinacionRad));
            double constanteSolar = 0.1367;
            double radiacion = constanteSolar * Math.cos(anguloIncidencia) * (1 + 0.033 * Math.cos(Math.toRadians(360 * dia / 360)));
            double eficienciaPanel = 0.16;
            double factorPerdidas = 0.9;
            produccionEnergia = area * radiacion * eficienciaPanel * factorPerdidas;
        }

        return (float) produccionEnergia * 100;
    }

    private ArrayList<String> getMonths()
    {
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

package com.example.solarsports;

public enum TipoPanel
{
    MONOCRISTALINO("Monocristalino", 0.45),
    POLICRISTALINO("Policristalino", 0.35),
    SOLAR_FLEXIBLE("Flexible", 0.15);

    private final String descripcion;
    private final double valor;

    TipoPanel(String descripcion, double valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getValor() {
        return valor;
    }

    public static double obtenerValorPorDescripcion(String descripcion)
    {
        for (TipoPanel tipo : TipoPanel.values()) {
            if (tipo.getDescripcion().equalsIgnoreCase(descripcion)) {
                return tipo.getValor();
            }
        }
        throw new IllegalArgumentException("Descripción no válida: " + descripcion);
    }

    @Override
    public String toString() {
        return descripcion;
    }
}

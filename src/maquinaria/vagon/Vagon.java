package maquinaria.vagon;

import estacion.IEstacion;

public class Vagon implements IEstacion {
    // Enumerados
    public enum Mercancia {
        LIQUIDO, SOLIDO, GAS, ALIMENTO, VACIO
    }

    // Atributos
    private double capacidadMax, capacidadAct;
    private Mercancia tipoMercancia;
    private boolean reservado;

    // Constructores
    public Vagon() {
        this(0.0, 0.0, Mercancia.VACIO, false);
    }

    public Vagon(double capacidadMax, double capacidadAct, Mercancia tipoMercancia, boolean reservado) {
        this.capacidadMax = capacidadMax;
        this.capacidadAct = capacidadAct;
        this.tipoMercancia = tipoMercancia;
        this.reservado = reservado;
    }

    // Getters and Setters
    public double getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(double capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public double getCapacidadAct() {
        return capacidadAct;
    }

    public void setCapacidadAct(double capacidadAct) {
        this.capacidadAct = capacidadAct;
    }

    public Mercancia getTipoMercancia() {
        return tipoMercancia;
    }

    public void setTipoMercancia(Mercancia tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    // Métodos

    @Override
    public String toString() {
        String cad;
        if (reservado)
            cad = "Si";
        else
            cad = "No";

        return "Vagon de mercancía" +
                "\nCapacidad Máxima: " + capacidadMax + " Kg" +
                "\nCapacidad Actual: " + capacidadAct + " Kg" +
                "\nTipo de Mercancia: " + tipoMercancia.toString().toLowerCase() +
                "\nReservado: " + cad;
    }
}

package maquinaria.locomotora;

import empleado.mecanico.Mecanico;
import estacion.Estacion;

public class Locomotora implements Estacion {
    // Atributos
    private String matricula;
    private Mecanico mecanico;
    private int antiguedad, potencia;
    private boolean reservado;

    // Constructores
    public Locomotora() {
        this("", null, 0, 0, false);
    }

    public Locomotora(String matricula, Mecanico mecanico, int antiguedad, int potencia, boolean reservado) {
        this.matricula = matricula;
        this.mecanico = mecanico;
        this.antiguedad = antiguedad;
        this.potencia = potencia;
        this.reservado = reservado;
    }

    // Getters and Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
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

        return "Locomotora" +
                "\nMatricula: " + matricula +
                "\nMecanico: " + mecanico.getNombre() +
                "\nAntiguedad (meses): " + antiguedad +
                "\nPotencia: " + potencia +
                "\nReservado: " + cad;
    }
}

package empleado.maquinista;

import empleado.Empleado;
import estacion.Estacion;

public class Maquinista extends Empleado implements Estacion {
    // Enumerado
    public enum Rango {
        APRENDIZ, ASISTENTE, PRINCIPAL, JEFE, INSTRUCTOR, SIN_RANGO
    }

    // Atributos
    private Rango rango;
    private boolean ocupado;

    // Constructores
    public Maquinista() {
        this("", "", Rango.SIN_RANGO, false);
    }

    public Maquinista(String nombre, String dni, Rango rango, boolean ocupado) {
        super(nombre, dni);
        this.rango = rango;
        this.ocupado = ocupado;
    }

    // Getters and Setters

    /*
    public Rango getRango() {
        return rango;
    }
    */
    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    // Métodos

    @Override
    public String toString() {
        String cad;
        if (ocupado)
            cad = "Si";
        else
            cad = "No";

        return "Maquinista\n" + super.toString() +
                "\nEspecialidad: " + rango.toString().toLowerCase() +
                "\nOcupado: " + cad;

    }
}

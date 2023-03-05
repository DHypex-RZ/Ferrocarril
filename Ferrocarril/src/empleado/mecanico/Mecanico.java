package empleado.mecanico;

import empleado.Empleado;
import estacion.Estacion;

public class Mecanico extends Empleado implements Estacion {
    // Enumerado
    public enum Especilidad{
        MANTENIMIENTO, REPACION, ELECTRONICA, FRENOS, TRANSMISION, SIN_ESPECIALIDAD;
    }

    // Atributos
    private Especilidad especilidad;
    private boolean ocupado;

    // Constructores
    public Mecanico() {
        this("", "", Especilidad.SIN_ESPECIALIDAD, false);
    }

    public Mecanico(String nombre, String dni, Especilidad especilidad, boolean ocupado) {
        super(nombre, dni);
        this.especilidad = especilidad;
        this.ocupado = ocupado;
    }

    // Getters and Setters
    public Especilidad getEspecilidad() {
        return especilidad;
    }

    public void setEspecilidad(Especilidad especilidad) {
        this.especilidad = especilidad;
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

        if(ocupado)
            cad="Si";
        else
            cad="No";

        return "Mecanico\n" + super.toString()+
                "\nEspecilidad: " + especilidad +
                "\nOcupado: " + cad;
    }
}

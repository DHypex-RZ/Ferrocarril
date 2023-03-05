package empleado.jefe;

import empleado.Empleado;
import estacion.Estacion;

public class Jefe extends Empleado implements Estacion {
    // Atributos
    private double sueldo;

    // Constructores
    public Jefe() {
        this("", "", 0.0);
    }

    public Jefe(String nombre, String dni, double sueldo) {
        super(nombre, dni);
        this.sueldo = sueldo;
    }

    // Getters and Setters
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    // Métodos
    @Override
    public String toString() {
        return "Jefe de estación\n" +super.toString()+
                "\nSueldo: " + sueldo;
    }


}

package empleado;

public class Empleado {
    // Atributos
    protected String nombre, dni;

    // Constructores
    public Empleado() {
        this("", "");
    }

    public Empleado(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    // Métodos
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDNI: " + dni;
    }
}

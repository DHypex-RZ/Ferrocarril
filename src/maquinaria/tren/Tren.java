package maquinaria.tren;

import empleado.maquinista.Maquinista;
import estacion.IEstacion;
import maquinaria.locomotora.Locomotora;
import maquinaria.vagon.Vagon;

public class Tren implements IEstacion {
    // Atributos
    private String nombre;
    private Maquinista maquinista;
    private Locomotora locomotora;
    private int numeroVagones;
    private Vagon[] vagones;

    // Constructores
    public Tren() {
        this("", null, null, 0);
    }

    public Tren(String nombre, Maquinista maquinista, Locomotora locomotora, int numeroVagones) {
        this.nombre = nombre;
        this.maquinista = maquinista;
        this.locomotora = locomotora;
        this.numeroVagones = numeroVagones;
        vagones = new Vagon[5];
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Maquinista getMaquinista() {
        return maquinista;
    }

    public void setMaquinista(Maquinista maquinista) {
        this.maquinista = maquinista;
    }

    public Locomotora getLocomotora() {
        return locomotora;
    }

    public void setLocomotora(Locomotora locomotora) {
        this.locomotora = locomotora;
    }

    public Vagon[] getVagones() {
        return vagones;
    }

    public int getNumeroVagones() {
        return numeroVagones;
    }

    public void setNumeroVagones(int numeroVagones) {
        this.numeroVagones = numeroVagones;
    }

    /*
    public void setVagones(Vagon[] vagones) {
        this.vagones = vagones;
    }
    */
    // Métodos

    @Override
    public String toString() {
        /*
        String cad = "";

        for (int i = 0; i < numeroVagones; i++)
            if (vagones[i] != null)
                cad += vagones[i].toString() + "\n";
         */

        StringBuilder cad = new StringBuilder();

        for (int i = 0; i < numeroVagones; i++)
            if (vagones[i] != null)
                cad.append(vagones[i].toString()).append("\n");

        return "Tren" +
                "\nNombre: " + nombre +
                "\nMaquinista: " + maquinista.getNombre() +
                "\nLocomotora: " + locomotora.getMatricula() +
                "\nNúmero de vagones: " + numeroVagones +
                "\n" + cad;
    }
}

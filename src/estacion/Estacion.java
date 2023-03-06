package estacion;

import empleado.jefe.Jefe;
import empleado.maquinista.Maquinista;
import empleado.mecanico.Mecanico;
import maquinaria.locomotora.Locomotora;
import maquinaria.tren.Tren;
import maquinaria.vagon.Vagon;

public interface Estacion {
    // Atributos
    int cantidad = 10;
    Jefe[] jefes = new Jefe[cantidad];
    Maquinista[] maquinistas = new Maquinista[cantidad];
    Mecanico[] mecanicos = new Mecanico[cantidad];
    Tren[] trenes = new Tren[cantidad];
    Locomotora[] locomotoras = new Locomotora[cantidad];
    Vagon[] vagones = new Vagon[cantidad];
}
package util;

import empleado.jefe.Jefe;
import empleado.maquinista.Maquinista;
import empleado.mecanico.Mecanico;
import maquinaria.locomotora.Locomotora;
import maquinaria.tren.Tren;
import maquinaria.vagon.Vagon;

import java.util.Scanner;

import static estacion.IEstacion.*;
import static util.comprobar.Comprobar.esIgualS;

public class AsignarInfo {
    public void start(){
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Deseas iniciar el programa con información? pulsa(s): ");
        if(esIgualS(sc.next().charAt(0)))
            asignar();
    }

    private void asignar() {
        jefes[0] = new Jefe("Ejemplo","Ejemplo",-1);
        maquinistas[0] = new Maquinista("Ejemplo","Ejemplo", Maquinista.Rango.SIN_RANGO, false);
        mecanicos[0] = new Mecanico("Ejemplo","Ejemplo", Mecanico.Especilidad.SIN_ESPECIALIDAD, true);
        locomotoras[0] = new Locomotora("Ejm-plo", mecanicos[0], -1, -1, false);
        vagones[0] = new Vagon(50000.0,0.0, Vagon.Mercancia.VACIO, false);
        vagones[1] = new Vagon(50000.0,0.0, Vagon.Mercancia.VACIO, false);
        vagones[2] = new Vagon(50000.0,0.0, Vagon.Mercancia.VACIO, false);

    }
}

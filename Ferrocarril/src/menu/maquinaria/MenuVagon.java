package menu.maquinaria;

import estacion.Estacion;
import maquinaria.vagon.Vagon;
import menu.MenuEstacion;

import static estacion.Estacion.vagones;
import static util.array.Array.*;
import static util.comprobar.Comprobar.esDiferenteS;
import static util.pantalla.Pantalla.*;

public class MenuVagon implements MenuEstacion {
    @Override
    public void visualizar() {
        char c;

        do {
            borrar();
            System.out.println("|=====================================|");
            System.out.println("|>               VAGÓN               <|");
            System.out.println("|=====================================|");
            System.out.println("| 1. DAR DE ALTA                      |");
            System.out.println("| 2. DAR DE BAJA                      |");
            System.out.println("| 3. INFORMACIÓN                      |");
            System.out.println("| 4. MODIFICAR VAGÓN                  |");
            System.out.println("| 5. SALIR DEL APARTADO               |");
            System.out.println("=======================================\n");
            c = opcionMenu();
            escogerOpcion(c);
            borrar();
        } while (c != '5');
    }

    @Override
    public void escogerOpcion(char opcion) {
        switch (opcion){
            case '1' -> {
                if(!lleno(vagones)){
                    Vagon vagon;
                    do {
                        String cad = "DAR ALTA VAGÓN";
                        System.out.println(cad + "\n" + "=".repeat(cad.length()) + "\n");
                        vagon = (Vagon) darAlta();
                    }while (esDiferenteS(confirmarAlta()));

                    vagones[cantidad(vagones)]= vagon;
                }else {
                    System.out.println("No se puede dar de alta a más locomotoras");
                    continuar();
                }
            }
            case '2' -> {
                if (!vacio(vagones)){
                    darBaja();
                    compactar(vagones);
                }else {
                    System.out.println("No hay datos");
                    continuar();
                }
            }
            case '3' -> {
                mostrarInformacion(vagones);
                continuar();
            }
            case '4' -> {
                if(!vacio(vagones)){
                    mostrarInformacion(vagones);
                    do {
                        modificar();
                    }while (esDiferenteS(confirmarCambio()));

                }else{
                    System.out.println("No hay datos");
                    continuar();
                }
            }
            case '5' -> salir();
            default -> noValido();
        }
    }

    @Override
    public Estacion darAlta() {
        Vagon vagon = new Vagon();

        System.out.print("Si desea dar de alta a un vagon sin especificaciones pulsa(s): ");
        if (esDiferenteS(sc.next().charAt(0))) {
            do {
                System.out.print("Capacidad máxima: ");
                vagon.setCapacidadMax(sc.nextDouble());
            } while (vagon.getCapacidadMax() <= 0);
            do {
                System.out.print("Capacidad actual: ");
                vagon.setCapacidadAct(sc.nextDouble());
            } while (vagon.getCapacidadAct() < 0 || vagon.getCapacidadAct() > vagon.getCapacidadMax());
            System.out.println(
                    "\"Mercancia ( VACIO, LIQUIDO, SOLIDO, GAS, ALIMENTO )\"\nMercancía: ");
            vagon.setTipoMercancia(Vagon.Mercancia.valueOf(sc.next().toUpperCase()));
        } else {
            System.out.println("Capacidad máxima: 50.000 Kg");
            System.out.println("Capacidad actual: Vacío");
            System.out.println("Mercancía: Vacío");
            vagon.setCapacidadMax(500000);
            vagon.setCapacidadAct(0);
        }
        return vagon;
    }

    @Override
    public void darBaja() {
        int n;

        do {
            System.out.print("Vagón: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(vagones));
        if(!vagones[n - 1].isReservado())
            vagones[n - 1] = null;
        else
            System.out.println("No se puede dar de baja, el vagón esta montada en un tren");

    }

    @Override
    public void modificar() {
        int n;

        do {
            System.out.print("Vagón a modificar: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(vagones));
        System.out.println(vagones[n-1]);
        System.out.println(vagones[n-1] + "\n" +"=".repeat(10));
        vagones[n-1] = (Vagon) darAlta();
    }
}
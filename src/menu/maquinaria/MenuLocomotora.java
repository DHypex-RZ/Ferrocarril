package menu.maquinaria;

import estacion.IEstacion;
import maquinaria.locomotora.Locomotora;
import menu.IMenuEstacion;
import menu.personal.MenuMecanico;

import static estacion.IEstacion.locomotoras;
import static estacion.IEstacion.mecanicos;
import static util.array.Array.*;
import static util.comprobar.Comprobar.esDiferenteS;
import static util.comprobar.Comprobar.esIgualS;
import static util.pantalla.Pantalla.*;

public class MenuLocomotora implements IMenuEstacion {
    @Override
    public void visualizar() {
        char c;

        do {
            borrar();
            System.out.println("|=====================================|");
            System.out.println("|>            LOCOMOTORA             <|");
            System.out.println("|=====================================|");
            System.out.println("| 1. DAR DE ALTA                      |");
            System.out.println("| 2. DAR DE BAJA                      |");
            System.out.println("| 3. INFORMACIÓN                      |");
            System.out.println("| 4. MODIFICAR LOCOMOTORA             |");
            System.out.println("| 5. SALIR DEL APARTADO               |");
            System.out.println("=======================================");
            System.out.println();
            c = opcionMenu();
            escogerOpcion(c);
            borrar();
        } while (c != '5');
    }

    @Override
    public void escogerOpcion(char opcion) {
        switch (opcion) {
            case '1' -> {
                if (vacio(mecanicos)) {
                    System.out.println(
                            "La locomotora necesita un mecánico, para continuar debe dar de alta a un mecánico");
                    if (esIgualS(nuevaAlta())) {
                        borrar();
                        new MenuMecanico().escogerOpcion('1');
                    } else {
                        System.out.println("No se dará de alta a la locomotora");
                        continuar();
                        break;
                    }
                }

                if (!lleno(locomotoras)) {
                    Locomotora locomotora;
                    do {
                        String cad = "DAR ALTA LOCOMOTORA";
                        System.out.println(cad + "\n" + "=".repeat(cad.length()) + "\n");
                        locomotora = (Locomotora) darAlta();
                    } while (esDiferenteS(confirmarAlta()));

                    locomotoras[cantidad(locomotoras)] = locomotora;
                } else {
                    System.out.println("No se puede dar de alta a la locomotora");
                    continuar();
                }
            }
            case '2' -> {
                if (!vacio(locomotoras)) {
                    mostrarInformacion(locomotoras);
                    darBaja();
                    compactar(locomotoras);
                } else {
                    System.out.println("No hay datos");
                    continuar();
                }
            }
            case '3' -> {
                mostrarInformacion(locomotoras);
                continuar();
            }
            case '4' -> {
                if (!vacio(locomotoras)) {
                    mostrarInformacion(locomotoras);
                    do {
                        modificar();
                    } while (esDiferenteS(confirmarCambio()));

                } else {
                    System.out.println("No hay datos");
                    continuar();
                }
            }
            case '5' -> {   }
            default -> noValido();
        }
    }

    @Override
    public IEstacion darAlta() {
        Locomotora locomotora = new Locomotora();
        int n;

        mostrarInformacion(mecanicos);

        do {
            do {
                System.out.print("Seleccione el número del mecánico\nMecánico: "); //todo: corregir error al selecionar un mecanico cuando es creado por un tren
                n = sc.nextInt();
            } while (n <= 0 || n > cantidad(mecanicos));
            if (!mecanicos[n - 1].isOcupado()) {
                locomotora.setMecanico(mecanicos[n - 1]);
                locomotora.getMecanico().setOcupado(true);
                break;
            } else {
                System.out.println("Este maquinista ya esta ocupado con otra locomotora");
            }
        } while (true);
        System.out.print("Matricula: ");
        locomotora.setMatricula(sc.next());
        do {
            System.out.print("Potencia: ");
            locomotora.setPotencia(sc.nextInt());
        } while (locomotora.getPotencia() <= 0);
        do {
            System.out.print("Antigüedad (mes/es): ");
            n = sc.nextInt();
        } while (n < 0);
        locomotora.setAntiguedad(n);

        return locomotora;
    }

    @Override
    public void darBaja() {
        int n;

        do {
            System.out.print("Locomotora: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(locomotoras));
        if (!locomotoras[n - 1].isReservado()) {
            locomotoras[n - 1].getMecanico().setOcupado(false);
            locomotoras[n - 1] = null;
        } else
            System.out.println("No se puede dar de baja, la locomotora esta montada en un tren");
    }

    @Override
    public void modificar() {
        int n;

        do {
            System.out.print("Locomotora a modificar: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(locomotoras));
        System.out.println(locomotoras[n - 1]);
        System.out.println(locomotoras[n - 1] + "\n" + "=".repeat(10));
        locomotoras[n - 1].getMecanico().setOcupado(false);
        locomotoras[n - 1] = (Locomotora) darAlta();
    }
}

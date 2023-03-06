package menu.personal;

import empleado.mecanico.Mecanico;
import estacion.Estacion;
import menu.MenuEstacion;

import static estacion.Estacion.mecanicos;
import static util.array.Array.*;
import static util.comprobar.Comprobar.esDiferenteS;
import static util.pantalla.Pantalla.*;

public class MenuMecanico implements MenuEstacion {
    @Override
    public void visualizar() {
        char c;

        do {
            borrar();
            System.out.println("========================================");
            System.out.println("|>              MECÁNICO              <|");
            System.out.println("|======================================|");
            System.out.println("| 1. DAR DE ALTA                       |");
            System.out.println("| 2. DAR DE BAJA                       |");
            System.out.println("| 3. INFORMACIÓN                       |");
            System.out.println("| 4. MODIFICAR MECÁNICO                |");
            System.out.println("| 5. SALIR DEL APARTADO                |");
            System.out.println("========================================\n");
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
                if (!lleno(mecanicos)) {
                    Mecanico mecanico;
                    do {
                        String cad = "DAR ALTA MECÁNICO";
                        System.out.println(cad + "\n" + "=".repeat(cad.length()) + "\n");
                        mecanico = (Mecanico) darAlta();
                    } while (esDiferenteS(confirmarAlta()));

                    mecanicos[cantidad(mecanicos)] = mecanico;
                }

                else {
                    System.out.println("No se puede dar de alta a más mecánicos");
                    continuar();
                }
            }
            case '2' -> {
                if (!vacio(mecanicos)) {
                    darBaja();
                    compactar(mecanicos);
                } else {
                    System.out.println("No hay datos");
                    continuar();
                }
            }
            case '3' -> {
                mostrarInformacion(mecanicos);
                continuar();
            }
            case '4' -> {
                if (!vacio(mecanicos)) {
                    mostrarInformacion(mecanicos);
                    do {
                        modificar();
                    } while (esDiferenteS(confirmarCambio()));

                } else {
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
        Mecanico mecanico = new Mecanico();
        System.out.print("Nombre: ");
        mecanico.setNombre(sc.next());
        do {
            System.out.print("DNI: ");
            mecanico.setDni(sc.next());
        } while (mecanico.getDni().length() > 9);
        System.out.print("Especilidad ( MANTENIMIENTO, REPACION, ELECTRONICA, FRENOS, TRANSMISION )\nEspecialidad: ");
        mecanico.setEspecilidad(Mecanico.Especilidad.valueOf(sc.next().toUpperCase()));
        return mecanico;
    }

    @Override
    public void darBaja() {
        int n;

        do {
            System.out.print("Mecánico: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(mecanicos));
        if (!mecanicos[n - 1].isOcupado())
            mecanicos[n - 1] = null;
        else
            System.out.println("No se puede dar de baja, el mecánico esta ocupado manteniendo una locomotora");
    }

    @Override
    public void modificar() {
        int n;

        do {
            System.out.print("Mecánico a modificar: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(mecanicos));
        System.out.println(mecanicos[n - 1]);
        System.out.println(mecanicos[n - 1] + "\n" + "=".repeat(10));
        mecanicos[n - 1] = (Mecanico) darAlta();
    }
}
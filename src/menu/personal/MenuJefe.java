package menu.personal;

import empleado.jefe.Jefe;
import estacion.IEstacion;
import menu.IMenuEstacion;

import static estacion.IEstacion.jefes;
import static util.array.Array.*;
import static util.comprobar.Comprobar.esDiferenteS;
import static util.pantalla.Pantalla.*;

public class MenuJefe implements IMenuEstacion {
    @Override
    public void visualizar() {
        char c;

        do {
            borrar();
            System.out.println("|======================================|");
            System.out.println("|>          JEFE DE ESTACIÓN          <|");
            System.out.println("|======================================|");
            System.out.println("| 1. DAR DE ALTA                       |");
            System.out.println("| 2. DAR DE BAJA                       |");
            System.out.println("| 3. INFORMACIÓN                       |");
            System.out.println("| 4. MODIFICAR JEFE DE ESTACIÓN        |");
            System.out.println("| 5. SALIR DEL APARTADO                |");
            System.out.println("========================================\n");
            c = opcionMenu();
            escogerOpcion(c);
            borrar();
        } while (c != '5');
    }

    @Override
    public void escogerOpcion(char opcion) {
        switch (opcion) {
            case '1' -> {
                if (!lleno(jefes)) {
                    Jefe jefe;
                    do {
                        String cad = "DAR ALTA JEFE DE ESTACIÓN";
                        System.out.println(cad + "\n" + "=".repeat(cad.length()) + "\n");
                        jefe = (Jefe) darAlta();
                    } while (esDiferenteS(confirmarAlta()));

                    jefes[cantidad(jefes)] = jefe;
                }

                else {
                    System.out.println("No se puede dar de alta a más jefes de estación");
                    continuar();
                }
            }
            case '2' -> {
                if (!vacio(jefes)) {
                    darBaja();
                    compactar(jefes);
                } else {
                    System.out.println("No hay datos");
                    continuar();
                }

            }
            case '3' -> {
                mostrarInformacion(jefes);
                continuar();
            }
            case '4' -> {
                if (!vacio(jefes)) {
                    mostrarInformacion(jefes);
                    do {
                        modificar();
                    } while (esDiferenteS(confirmarCambio()));

                } else {
                    System.out.print("No hay datos");
                    continuar();
                }
            }
            case '5' -> salir();
            default -> noValido();
        }
    }

    @Override
    public IEstacion darAlta() {
        Jefe jefe = new Jefe();

        System.out.print("Nombre: ");
        jefe.setNombre(sc.next());
        do {
            System.out.print("DNI: ");
            jefe.setDni(sc.next());
        } while (jefe.getDni().length() > 9);
        do {
            System.out.print("Sueldo: ");
            jefe.setSueldo(sc.nextDouble());
        } while (jefe.getSueldo() <= 0);

        return jefe;
    }

    @Override
    public void darBaja() {
        int n;

        do {
            System.out.print("Jefe de estación: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(jefes));
        jefes[n - 1] = null;
    }

    @Override
    public void modificar() {
        int n;

        do {
            System.out.print("Jefe de estación ha modificar: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(jefes));
        borrar();
        System.out.println(jefes[n - 1] + "\n" + "=".repeat(10));
        jefes[n - 1] = (Jefe) darAlta();
    }
}

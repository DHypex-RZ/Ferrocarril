package menu.personal;

import empleado.maquinista.Maquinista;
import estacion.Estacion;
import menu.MenuEstacion;

import static estacion.Estacion.maquinistas;
import static util.array.Array.*;
import static util.comprobar.Comprobar.esDiferenteS;
import static util.pantalla.Pantalla.*;

public class MenuMaquinista implements MenuEstacion {
    @Override
    public void visualizar() {
        char c;

        do {
            borrar();
            System.out.println("|======================================|");
            System.out.println("|>             MAQUINISTA             <|");
            System.out.println("|======================================|");
            System.out.println("| 1. DAR DE ALTA                       |");
            System.out.println("| 2. DAR DE BAJA                       |");
            System.out.println("| 3. INFORMACIÓN                       |");
            System.out.println("| 4. MODIFICAR MAQUINISTA              |");
            System.out.println("| 5. SALIR DEL APARTADO                |");
            System.out.println("========================================");
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
                if (!lleno(maquinistas)) {
                    Maquinista maquinista;
                    do {
                        String cad = "DAR ALTA MAQUINISTA";
                        System.out.println(cad + "\n" + "=".repeat(cad.length()) + "\n");
                        maquinista = (Maquinista) darAlta();
                    } while (esDiferenteS(confirmarAlta()));

                    maquinistas[cantidad(maquinistas)] = maquinista;
                } else {
                    System.out.println("No se puede dar de alta a más maquinistas");
                    continuar();
                }
            }
            case '2' -> {
                if (!vacio(maquinistas)) {
                    darBaja();
                    compactar(maquinistas);
                } else {
                    System.out.println("No hay datos");
                    continuar();
                }
            }
            case '3' -> {
                mostrarInformacion(maquinistas);
                continuar();
            }
            case '4' -> {
                if (!vacio(maquinistas)) {
                    mostrarInformacion(maquinistas);
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
        Maquinista maquinista = new Maquinista();

        System.out.print("Nombre: ");
        maquinista.setNombre(sc.next());
        do {
            System.out.print("DNI: ");
            maquinista.setDni(sc.next());
        } while (maquinista.getDni().length() > 9);
        System.out.print("Rango ( APRENDIZ, ASISTENTE, PRINCIPAL, JEFE, INSTRUCTOR )\nRango: ");
        maquinista.setRango(Maquinista.Rango.valueOf(sc.next().toUpperCase()));
        return maquinista;
    }

    @Override
    public void darBaja() {
        int n;

        do {
            System.out.print("Maquinista: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(maquinistas));
        if (!maquinistas[n - 1].isOcupado())
            maquinistas[n - 1] = null;
        else
            System.out.println("No se puede dar de baja, el maquinista esta ocupado conduciendo un tren");
    }

    @Override
    public void modificar() {
        int n;

        do {
            System.out.print("Maquinista a modificar: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(maquinistas));
        System.out.println(maquinistas[n - 1]);
        System.out.println(maquinistas[n - 1] + "\n" + "=".repeat(10));
        maquinistas[n - 1] = (Maquinista) darAlta();
    }
}
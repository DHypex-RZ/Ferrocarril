package menu.personal;

import menu.IMenu;

import static util.pantalla.Pantalla.*;

public class Personal implements IMenu {
    @Override
    public void visualizar() {
        char c;

        do {
            borrar();
            System.out.println("|======================================|");
            System.out.println("|>              PERSONAL              <|");
            System.out.println("|======================================|");
            System.out.println("| 1. JEFE DE ESTACIÓN                  |");
            System.out.println("| 2. MAQUINISTA                        |");
            System.out.println("| 3. MECÁNICO                          |");
            System.out.println("| 4. SALIR DE EMPLEADOS                |");
            System.out.println("========================================\n");
            c = opcionMenu();
            escogerOpcion(c);
            borrar();
        } while (c != '4');
    }

    @Override
    public void escogerOpcion(char opcion) {
        switch (opcion) {
            case '1' -> new MenuJefe().visualizar();
            case '2' -> new MenuMaquinista().visualizar();
            case '3' -> new MenuMecanico().visualizar();
            case '4' -> salir();
            default -> noValido();
        }
    }
}
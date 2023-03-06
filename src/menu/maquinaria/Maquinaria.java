package menu.maquinaria;

import menu.Menu;

import static util.pantalla.Pantalla.*;

public class Maquinaria implements Menu {
    @Override
    public void visualizar() {
        char c;

        do {
            borrar();
            System.out.println("|======================================|");
            System.out.println("|>             MAQUINARIA             <|");
            System.out.println("|======================================|");
            System.out.println("| 1. TREN                              |");
            System.out.println("| 2. LOCOMOTORA                        |");
            System.out.println("| 3. VAGÓN                             |");
            System.out.println("| 4. SALIR DE MAQUINARIAS              |");
            System.out.println("========================================\n");
            c = opcionMenu();
            escogerOpcion(c);
            borrar();
        } while (c != '4');
    }

    @Override
    public void escogerOpcion(char opcion) {
        switch (opcion) {
            case '1' -> new MenuTren().visualizar();
            case '2' -> new MenuLocomotora().visualizar();
            case '3' -> new MenuVagon().visualizar();
            case '4' -> salir();
            default -> noValido();
        }
    }
}
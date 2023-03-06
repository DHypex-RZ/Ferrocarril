package menu.principal;

import menu.Menu;
import menu.maquinaria.Maquinaria;
import menu.personal.Personal;

import static util.pantalla.Pantalla.*;

public class Principal implements Menu {
    @Override
    public void visualizar() {
        char c;

        do {
            borrar();
            System.out.println("|======================================|");
            System.out.println("|> BIENVENIDOS AL SISTEMA FERROVIARIO <|");
            System.out.println("|======================================|");
            System.out.println("| 1. PERSONAL                          |");
            System.out.println("| 2. MAQUINARIA                        |");
            System.out.println("| 3. FINALIZAR PROGRAMA                |");
            System.out.println("========================================\n");
            c = opcionMenu();
            escogerOpcion(c);
            borrar();
        } while (c != '3');
    }

    @Override
    public void escogerOpcion(char opcion) {
        switch (opcion) {
            case '1' -> new Personal().visualizar();
            case '2' -> new Maquinaria().visualizar();
            case '3' -> salir();
            default -> noValido();
        }
    }
}
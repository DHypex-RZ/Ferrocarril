package menu;

import java.util.Scanner;

public interface Menu {
    Scanner sc = new Scanner(System.in);

    void visualizar();
    void escogerOpcion(char opcion);

    default void salir() {
    }

}

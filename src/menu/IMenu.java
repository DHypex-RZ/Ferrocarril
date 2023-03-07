package menu;

import java.util.Scanner;

public interface IMenu {
    Scanner sc = new Scanner(System.in);

    void visualizar();
    void escogerOpcion(char opcion);

}

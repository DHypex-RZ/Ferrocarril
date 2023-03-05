package util.pantalla;

import java.util.Scanner;

public class Pantalla {
    public static char opcionMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Opcion: ");
        return sc.next().charAt(0);
    }

    public static void borrar() {
        System.out.println();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void noValido() {
        System.out.println("Opción no válida");
        continuar();
    }

    public static void continuar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Pulse [ENTER] para continuar: ");
        sc.nextLine();
    }

    public static char confirmarAlta() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Si los datos son correctos pulsa(s) para dar de alta: ");
        return sc.next().charAt(0);
    }

    public static char confirmarCambio() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Si los datos son correctos pulsa(s) para dar cambiar la información: ");
        return sc.next().charAt(0);
    }

    public static char nuevaAlta() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Si desea dar de alta pulsa(s): ");
        return sc.next().charAt(0);
    }
}

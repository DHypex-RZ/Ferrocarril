package menu;

import estacion.IEstacion;

public interface IMenuEstacion extends IMenu {
    IEstacion darAlta();

    void darBaja();

    default void mostrarInformacion(IEstacion[] e) {
        int n = 1;
        for (IEstacion est : e) {
            if (est != null) {
                System.out.println(n + " - " + est + "\n");
                n++;
            }
        }
        if (n == 1)
            System.out.println("No hay datos");
    }

    void modificar();
}

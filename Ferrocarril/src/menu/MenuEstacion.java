package menu;

import estacion.Estacion;

public interface MenuEstacion extends Menu{
    Estacion darAlta();
    void darBaja();
    default void mostrarInformacion(Estacion[] e){
        int n=1;
        for (Estacion est : e) {
            if (est != null) {
                System.out.println(n + " - " + est + "\n");
                n++;
            }
        }
        if(n==1)
            System.out.println("No hay datos");
    }
    void modificar();
}

package util.array;

import estacion.Estacion;

public class Array {
    public static int cantidad(Estacion[] e) {
        int cont = 0;
        for (Estacion est : e) {
            if (est != null) {
                cont++;
            }
        }
        return cont;
    }

    public static boolean vacio(Estacion[] e) {
        if (e == null) {
            return true;
        }
        for (Estacion est : e) {
            if (est != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean lleno(Estacion[] e) {
        return cantidad(e) == e.length;
    }

    public static void compactar(Estacion[] e) {
        if (cantidad(e) > 0) {
            for (int i = 1; i < e.length; i++) {
                if (e[i - 1] == null && e[i] != null) {
                    e[i - 1] = e[i];
                    e[i] = null;
                }
            }
        }
    }
}

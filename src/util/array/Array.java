package util.array;

import estacion.IEstacion;

public class Array {
    public static int cantidad(IEstacion[] e) {
        int cont = 0;
        for (IEstacion est : e) {
            if (est != null) {
                cont++;
            }
        }
        return cont;
    }

    public static boolean vacio(IEstacion[] e) {
        if (e == null) {
            return true;
        }
        for (IEstacion est : e) {
            if (est != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean lleno(IEstacion[] e) {
        return cantidad(e) == e.length;
    }

    public static void compactar(IEstacion[] e) {
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

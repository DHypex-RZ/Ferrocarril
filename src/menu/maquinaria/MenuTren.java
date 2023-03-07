package menu.maquinaria;

import estacion.IEstacion;
import maquinaria.tren.Tren;
import menu.IMenuEstacion;
import menu.personal.MenuMaquinista;

import static estacion.IEstacion.*;
import static util.array.Array.cantidad;
import static util.array.Array.*;
import static util.comprobar.Comprobar.esDiferenteS;
import static util.comprobar.Comprobar.esIgualS;
import static util.pantalla.Pantalla.*;

public class MenuTren implements IMenuEstacion {
    @Override
    public void visualizar() {
        char c;

        do {
            borrar();
            System.out.println("|=====================================|");
            System.out.println("|>               TREN                <|");
            System.out.println("|=====================================|");
            System.out.println("| 1. DAR DE ALTA                      |");
            System.out.println("| 2. DAR DE BAJA                      |");
            System.out.println("| 3. INFORMACIÓN                      |");
            System.out.println("| 4. MODIFICAR TREN                   |");
            System.out.println("| 5. CAMBIAR VAGÓN                    |");
            System.out.println("| 6. SALIR DEL APARTADO               |");
            System.out.println("=======================================");
            System.out.println();
            c = opcionMenu();
            escogerOpcion(c);
            borrar();
        } while (c != '6');
    }

    @Override
    public void escogerOpcion(char opcion) {
        switch (opcion) {
            case '1' -> {
                if (vacio(maquinistas)) {
                    System.out
                            .println("El tren necesita un maquinista, para continuar debe dar de alta a un maquinista");
                    if (esIgualS(nuevaAlta())) {
                        borrar();
                        new MenuMaquinista().escogerOpcion('1');
                    } else {
                        System.out.println("No se dará de alta al tren");
                        continuar();
                        break;
                    }
                }

                if (vacio(locomotoras)) {
                    System.out.println(
                            "El tren necesita una locomotora, para continuar debe dar de alta a una locomotora");
                    if (esIgualS(nuevaAlta())) {
                        borrar();
                        new MenuLocomotora().escogerOpcion('1');
                    } else {
                        System.out.println("No se dará de alta al tren");
                        continuar();
                        break;
                    }
                }

                if (!lleno(locomotoras) && !vacio(maquinistas) && !vacio(locomotoras)) {
                    Tren tren;
                    do {
                        String cad = "DAR ALTA TREN";
                        System.out.println(cad + "\n" + "=".repeat(cad.length()) + "\n");
                        tren = (Tren) darAlta();
                    } while (esDiferenteS(confirmarAlta()));

                    trenes[cantidad(trenes)] = tren;
                } else {
                    System.out.println("No se puede dar de alta al tren");
                    continuar();
                }
            }
            case '2' -> {
                if (!vacio(trenes)) {
                    mostrarInformacion(trenes);
                    darBaja();
                    compactar(trenes);
                } else {
                    System.out.println("No hay datos");
                    continuar();
                }
            }
            case '3' -> {
                mostrarInformacion(trenes);
                continuar();
            }
            case '4' -> {
                if (!vacio(trenes)) {
                    mostrarInformacion(trenes);
                    do {
                        modificar();
                    } while (esDiferenteS(confirmarCambio()));

                } else {
                    System.out.println("No hay datos");
                    continuar();
                }
            }
            case '5' -> {
                if(!vacio(vagones))
                    modificarVagon();
                else {
                    System.out.println("No hay datos sobre vagones");
                    continuar();
                }
            }
            case '6' -> {   }
            default -> noValido();
        }
    }

    @Override
    public IEstacion darAlta() {
        Tren tren = new Tren();
        int n;

        System.out.print("Nombre: ");
        tren.setNombre(sc.next());
        mostrarInformacion(maquinistas);
        do {
            do {
                System.out.print("Seleccione el número del maquinista\nMaquinista: ");
                n = sc.nextInt();
            } while (n <= 0 || n > cantidad(maquinistas));
            if(!maquinistas[n - 1].isOcupado()){
                tren.setMaquinista(maquinistas[n - 1]);
                tren.getMaquinista().setOcupado(true);
                break;
            }else {
                System.out.println("El maquinista esta ocupado con otro tren");
            }
        }while (true);
        mostrarInformacion(locomotoras);
        do {
            do {
                System.out.print("Seleccione el número de locomotora\nLocomotora: ");
                n = sc.nextInt();
            } while (n <= 0 || n > cantidad(locomotoras));
            if(!locomotoras[n-1].isReservado()){
                tren.setLocomotora(locomotoras[n - 1]);
                tren.getLocomotora().setReservado(true);
                break;
            }else {
                System.out.println("La locomotora esta montada en otro tren");
            }
        }while (true);



        do {
            System.out.print("Cantidad de vagones (0 - 5): ");
            tren.setNumeroVagones(sc.nextInt());
        } while (tren.getNumeroVagones() < 0 || tren.getNumeroVagones() > tren.getVagones().length);
        if (vacio(vagones) || tren.getNumeroVagones() == 0)
            System.out.println("Actualmente no se puede añadir vagones");
        else {
            System.out.print("Si quiere añadir vagones pulsa(s): ");
            if (esIgualS(sc.next().charAt(0))) {
                char car;

                do {
                    mostrarInformacion(vagones);
                    do {
                        System.out.print("Selecciona el número del vagon\nVagon: ");
                        n = sc.nextInt();
                    } while (n <= 0 || n > cantidad(vagones));
                    if (vagones[n - 1].isReservado() || cantidad(tren.getVagones()) == tren.getNumeroVagones())
                        System.out.println("No se puede añadir el vagón");
                    else {
                        tren.getVagones()[cantidad(tren.getVagones())] = vagones[n - 1];
                        tren.getVagones()[cantidad(tren.getVagones())-1].setReservado(true);
                    }
                    System.out.print("Si desea añadir más vagones pulsa(s): ");
                    car = sc.next().charAt(0);
                } while (cantidad(tren.getVagones()) < tren.getNumeroVagones() || esDiferenteS(car));
            } else
                System.out.println("No ha añadido vagones");
        }
        return tren;
    }

    @Override
    public void darBaja() {
        int n;

        do {
            System.out.print("Tren: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(trenes));
        trenes[n - 1].getLocomotora().setReservado(false);
        for (int i = 0; i < trenes[n - 1].getNumeroVagones(); i++)
            if (trenes[n - 1].getVagones()[i] != null)
                trenes[n - 1].getVagones()[i].setReservado(false);
        trenes[n - 1] = null;
    }

    @Override
    public void modificar() {
        int n;

        do {
            System.out.print("Tren a modificar: ");
            n = sc.nextInt();
        } while (n < 0 || n > cantidad(trenes));
        System.out.println(trenes[n - 1]);
        System.out.println(trenes[n - 1] + "\n" + "=".repeat(10));
        trenes[n - 1].getMaquinista().setOcupado(false);
        trenes[n-1].getLocomotora().setReservado(false);
        for (int i = 0; i < trenes[n - 1].getNumeroVagones(); i++)
            if (trenes[n - 1].getVagones()[i] != null)
                trenes[n - 1].getVagones()[i].setReservado(false);
        trenes[n - 1] = (Tren) darAlta();
    }

    private void modificarVagon() {
        int n, e;
        char car;

        do {
            mostrarInformacion(trenes);
            do {
                System.out.print("Tren ha modificar: ");
                e = sc.nextInt() - 1;
            } while (e < 0 || e > cantidad(trenes));

            if (trenes[e].getNumeroVagones() == 0) {
                System.out.println("No se pueden añadir ni quitar vagones, ya que solo el tren solo admite 0 vagones");
                break;
            }

            System.out.print("¿Que desea hacer? añadir/quitar vagones (a/q): ");
            car = sc.next().charAt(0);
            if (car == 'a' || car == 'A') {
                if (cantidad(trenes[e].getVagones()) < trenes[e].getNumeroVagones()) {
                    do {
                        mostrarInformacion(vagones);
                        do {
                            System.out.print("Selecciona el número del vagon\nVagon: ");
                            n = sc.nextInt();
                        } while (n <= 0 && n > cantidad(vagones));
                        if (vagones[n - 1].isReservado() || cantidad(trenes) == trenes[e].getNumeroVagones())
                            System.out.println("No se puede añadir el vagón");
                        else {
                            trenes[e].getVagones()[cantidad(trenes[e].getVagones())] = vagones[n - 1];
                            trenes[e].getVagones()[cantidad(trenes[e].getVagones()) - 1].setReservado(true);
                        }
                        System.out.print("Si desea añadir más vagones pulsa(s): ");
                        car = sc.next().charAt(0);
                    } while (cantidad(trenes[e].getVagones()) < trenes[e].getNumeroVagones() && esIgualS(car));
                } else
                    System.out.println("No puedes añadir más vagones");
            } else if (car == 'q' || car == 'Q') {
                if(!vacio(trenes[e].getVagones())){
                    do {
                        mostrarInformacion(trenes[e].getVagones());
                        do {
                            System.out.print("Selecciona el número del vagon\nVagon: ");
                            n = sc.nextInt();
                        } while (n <= 0 && n > cantidad(trenes[e].getVagones()));
                        trenes[e].getVagones()[n - 1].setReservado(false);
                        trenes[e].getVagones()[n - 1] = null;
                        compactar(trenes[e].getVagones());
                        System.out.print("Si desea quitar más vagones pulsa(s): ");
                        car = sc.next().charAt(0);
                    } while (cantidad(trenes[e].getVagones()) > 0 || esDiferenteS(car));
                }else{
                    System.out.println("No hay vagones");
                    continuar();
                }
            } else {
                noValido();
                break;
            }
        } while (esDiferenteS(confirmarCambio()));
    }
}
import menu.principal.Principal;
import util.AsignarInfo;

public class Main {
    public static void main(String[] args) {
        new AsignarInfo().start();
        Principal incio = new Principal();
        incio.visualizar();
    }
}

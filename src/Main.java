import Datos.Libreria;
import Historia.Inicio;
import com.nicosteuerberg.datos.SacarMensaje;

public class Main {
    public static void main(String[] args) {
        String opciones[] = {"Jugar","Instrucciones","Salir"};
        int numero;
        do {
            numero = SacarMensaje.pedirOpciones("Bienvenido a Nina Adventure", opciones);
            switch (numero) {
                case 0:
                    Inicio.comienzo();
                    break;
                case 1:
                    Libreria.Instrucciones();
                    break;
                case 2:
                    SacarMensaje.sacarVentana("Saliendo del programa...");
                    break;
            }
        }while(numero==1);
    }
}

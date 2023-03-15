package Historia;

import com.nicosteuerberg.datos.SacarMensaje;

public class Cielo {
    public static void cielo(){
        SacarMensaje.sacarVentana("Al elegir su equipo Nina decide ponerse en marcha al cielo.\n"+
                "Antes de encontrar al primer dios se encuentra a un Ángel que le reta al piedra papel o tijera.\n"+
                "A Nina no le queda más opción que aceptar ya que le ofrece recompensas");

        /**ToDo
         * piedra papel o tijera
         */

        SacarMensaje.sacarVentana("Nina sigue con su travesía y se encuentra el primer dios: Poseidón");

        /**ToDo
         * pelea contra Poseidón
         */

        SacarMensaje.sacarVentana("Al derrotar a Poseidón, Nina se vuelve a encontrar al mismo ángel de antes\nque le vuelve a retar a lo mismo");

        /**ToDo
         * piedra papel o tijera
         * pelea contra Hera
         */

        SacarMensaje.sacarVentana("Al derrotar a Hera, Nina se vuelve a encontrar al ángel, cansada de él decide\n"+
                "luchar contra él para deshacerse de él, justo cuando van a pelear, Nina se entera\n"+
                "de que no es un ángle, si no, el dios más poderoso: Zeus");
        /**ToDo
         * pelea contra Zeus
         */

        Final.finalHistoria();
    }
}

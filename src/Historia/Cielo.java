package Historia;

import Batallas.BatallaBoss;
import Personajes.Bosses;
import Personajes.Subditos;
import com.nicosteuerberg.datos.SacarMensaje;

import java.util.ArrayList;

public class Cielo {
    public static void cielo(ArrayList<Subditos> equipo, ArrayList<Bosses> bosses){
        SacarMensaje.sacarVentana("Al elegir su equipo Nina decide ponerse en marcha al cielo.\n"+
                "Antes de encontrar al primer dios se encuentra a un Ángel que le reta al piedra papel o tijera.\n"+
                "A Nina no le queda más opción que aceptar ya que le ofrece recompensas");

        /**ToDo
         * piedra papel o tijera
         */

        SacarMensaje.sacarVentana("Nina sigue con su travesía y se encuentra el primer dios: Poseidón");

        BatallaBoss.batallaBoss(equipo,bosses,4);

        SacarMensaje.sacarVentana("Al derrotar a Poseidón, Nina se vuelve a encontrar al mismo ángel de antes\nque le vuelve a retar a lo mismo");

        /**ToDo
         * piedra papel o tijera
         */
        BatallaBoss.batallaBoss(equipo,bosses,5);

        SacarMensaje.sacarVentana("Al derrotar a Hera, Nina se vuelve a encontrar al ángel, cansada de él decide\n"+
                "luchar para deshacerse de él, justo cuando van a pelear, Nina se entera\n"+
                "de que no es un ángel, si no, el dios de las trampas: Loki");

        BatallaBoss.batallaBoss(equipo,bosses,6);

        Final.finalHistoria();
    }
}

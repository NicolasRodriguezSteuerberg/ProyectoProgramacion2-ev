package Historia;

import com.nicosteuerberg.datos.PedirDatos;
import com.nicosteuerberg.datos.SacarMensaje;

public class Infierno {
    public static void infierno(){

        /**ToDo
         * selección de personaje
         */

        SacarMensaje.sacarVentana("Nina para seguir su sueño se da cuenta que tendrá que luchar contra otros infernales\n"+
                "para ir aumentando el poder de su equipo y para conseguir más súbditos, además tendrá\n"+
                "que luchar contra Infernales de alto rango. De esta manera se encuentra a su primer enemigo.");

        /**ToDo
         * meter el tutorial + 2ª batalla
         */

        /**ToDo
         * añadir nuevo personaje
         */
        SacarMensaje.sacarVentana("Enhorabuena, has subido al nivel 2, tu súbdito a subido de poder.\n"+
                "Además has conseguido fama, gracias a esto ---- se ha unido a tu equipo\n"+
                "Al aumentar tu poder el primer infernal se ha interesado en luchar contigo.");

        /**ToDo
         * Batallas boss
         * Batallas preboss
         */

        //final infierno
        SacarMensaje.sacarVentana("Enhorabuena has ganado a todos los infernales y has conseguido\n"+
                "suficiente poder, por lo que has evolucionado a Princesa Demonio.\n"+
                "Tus súbditos han evolucionado ganando mucho poder.");

        SacarMensaje.sacarVentana("Todos los infernales quieren estar en tu equipo pero solo puedes tener 4.\n"+
                "Debes formar tu equipo para ponerte en marcha hacia el Cielo, en esta\n"+
                "etapa lucharás contra los dioses para lograr tu sueño");

        /**ToDo
         * Cambio de equipo
         */

        Cielo.cielo();


    }
}

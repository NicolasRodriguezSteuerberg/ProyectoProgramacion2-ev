package Historia;

import com.nicosteuerberg.datos.SacarMensaje;

public class Infierno {
    public static void infierno(){

        /**ToDo
         * añadir nuevo personaje
         */
        SacarMensaje.sacarVentana("Enhorabuena, has subido al nivel 2, tu súbdito a subido de poder.\nAdemás has conseguido fama, gracias a esto ---- se ha unido a tu equipo\nAl aumentar tu poder el primer infernal se ha interesado en luchar contigo.");

        /**ToDo
         * Batallas boss
         * Batallas preboss
         */

        //final infierno
        SacarMensaje.sacarVentana("Enhorabuena has ganado a todos los infernales y has conseguido\nsuficiente poder, por lo que has evolucionado a Princesa Demonio.\nTus súbditos han evolucionado ganando mucho poder.");
        SacarMensaje.sacarVentana("Todos los infernales quieren estar en tu equipo pero solo puedes tener 4.\nDebes formar tu equipo para ponerte en marcha hacia el Cielo, en esta\netapa lucharás contra los dioses para lograr tu sueño");
        /**ToDo
         * Cambio de equipo
         */
        Cielo.cielo();
    }
}

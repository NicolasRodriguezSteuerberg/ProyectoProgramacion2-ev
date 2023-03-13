package Historia;


import com.nicosteuerberg.datos.SacarMensaje;

public class Inicio {
    public static void comienzo(){
        //introducción de la historia
        SacarMensaje.sacarVentana("Nina, una profesora de programación, cansada de corregir proyectos. Aún sabiendo \nque solo le queda uno por corregir, decide ponerles un 0 para no mirarlo.\nSeguido de esto decide abandonar a sus alumnos para convertirse en Reina Demonio.\nPara llegar a esto decide marcharse al infierno");
        SacarMensaje.sacarVentana("Al llegar al infierno encuentra a 3 infernales de rango inferior, solos y moribundos.\nSabiendo que no tiene suficiente poder para domesticarlos, decide elegir a uno\ndejando tirado a los otros dos. Consiguiendo así a su primer súbdito.");

        /**ToDo
         * selección de personaje
         */

        SacarMensaje.sacarVentana("Nina para seguir su sueño se da cuenta que tendrá que luchar contra otros infernales\npara ir aumentando el poder de su equipo y para conseguir más súbditos, además tendrá\nque luchar contra Infernales de alto rango. De esta manera se encuentra a su primer enemigo.");

        /**ToDo
         * meter el tutorial + 2ª batalla
         */

        Infierno.infierno();
    }
}

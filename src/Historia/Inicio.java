package Historia;


import com.nicosteuerberg.datos.SacarMensaje;

public class Inicio {
    public static void comienzo(){
        //introducción de la historia
        SacarMensaje.sacarVentana("Nina, una profesora de programación, cansada de corregir proyectos. Aún sabiendo \n"+
                "que solo le queda uno por corregir, decide ponerles un 0 para no mirarlo.\n"+
                "Seguido de esto decide abandonar a sus alumnos para convertirse en Reina Demonio.\nPara llegar a esto decide marcharse al infierno");

        SacarMensaje.sacarVentana("Al llegar al infierno encuentra a 3 infernales de rango inferior, solos y moribundos.\n"+
                "Sabiendo que no tiene suficiente poder para domesticarlos, decide elegir a uno\n"+
                "dejando tirado a los otros dos. Consiguiendo así a su primer súbdito.");

        Infierno.infierno();
    }
}

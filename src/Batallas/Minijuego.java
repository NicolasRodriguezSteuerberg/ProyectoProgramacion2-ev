package Batallas;

import Datos.Libreria;
import com.nicosteuerberg.datos.PedirDatos;
import com.nicosteuerberg.datos.SacarMensaje;

import java.util.ArrayList;

public class Minijuego {
    public static final int PIEDRA=0;
    public static final int PAPEL=1;
    public static final int TIJERA=2;

    static String []opciones={"Piedra", "Papel", "Tijera"};


    public static void piedraPapelTijera(){
        int nPartidas=0;
        int opcionP,opcionR; //opcion jugador, opcion maquina
        String estado="empate";
        String emogiP,emogiR;
        int pGanadas=0;
        do {
            do {
                opcionP = SacarMensaje.pedirOpciones("¿Qué quieres sacar?",opciones);
                opcionR = Libreria.numeroRandom(PIEDRA,TIJERA);
                SacarMensaje.sacarVentana("Has sacado " + opciones[opcionP] + "\nEl ángel ha sacado: " + opciones[opcionR]);
                String mensaje=null;
                switch (opcionP) {
                    case PIEDRA:
                        switch (opcionR) {
                            case PIEDRA:
                                mensaje = "Ambos habeis sacado piedra, habeis empatado, reintentar la " + (nPartidas+1) +"º batalla";
                                estado = "empate";
                                break;
                            case PAPEL:
                                mensaje = "Piedra pierde contra papel, has perdido la " + (nPartidas+1) +"º batalla";
                                estado = "perdido";
                                break;
                            case TIJERA:
                                mensaje = "Piedra gana a tijeras, has ganado la " + (nPartidas+1) +"º batalla";
                                estado="ganado";
                        }
                        break;
                    case PAPEL:
                        switch (opcionR) {
                            case PIEDRA:
                                mensaje = "Papel gana a piedra, has ganado la " + (nPartidas+1) +"º batalla";
                                estado = "ganado";
                                break;
                            case PAPEL:
                                mensaje = "Ambos habeis sacado papel, habeis empatado, reintentar la " + (nPartidas+1) +"º batalla";
                                estado = "empate";
                                break;
                            case TIJERA:
                                mensaje = "Papel pierde contra tijera, has perdido la " + (nPartidas+1) +"º batalla";
                                estado="perdido";
                        }
                        break;
                    case TIJERA:
                        switch (opcionR) {
                            case PIEDRA:
                                mensaje = "Tijera pierde contra piedra, has perdido la " + (nPartidas+1) +"º batalla";
                                estado = "perdido";
                                break;
                            case PAPEL:
                                mensaje = "Tijera gana a papel, has ganado la " + (nPartidas+1) +"º batalla";
                                estado = "ganado";
                                break;
                            case TIJERA:
                                mensaje = "Ambos habéis sacado tijera, habeis empatado, reintentar la " + (nPartidas+1) +"º batalla";
                                estado="empate";
                        }
                        break;
                }

                SacarMensaje.sacarVentana(mensaje);

            }
            while (estado.equals("empate"));

            if (estado.equals("ganado")) {
                pGanadas++;
            }

            nPartidas++;
        }while(nPartidas<3);
        SacarMensaje.sacarVentana("Has ganado " + pGanadas + " partidas");
    }
}

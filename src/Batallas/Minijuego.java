package Batallas;

import Datos.Libreria;
import Personajes.Subditos;
import com.nicosteuerberg.datos.PedirDatos;
import com.nicosteuerberg.datos.SacarMensaje;

import java.util.ArrayList;

public class Minijuego {
    public static final int PIEDRA=0;
    public static final int PAPEL=1;
    public static final int TIJERA=2;

    static String []opciones={"Piedra", "Papel", "Tijera"};


    public static void piedraPapelTijera(ArrayList<Subditos> equipo){
        String nEquipos[] = {equipo.get(0).getNombre(),equipo.get(1).getNombre(),equipo.get(2).getNombre(),equipo.get(3).getNombre()};

        int nPartidas=0;
        int opcionP,opcionR,opcion,opcion2; //opcion jugador, opcion maquina
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
                                mensaje = "Ambos habeis sacado piedra, habeis empatado";
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
                                mensaje = "Ambos habeis sacado papel, habeis empatado";
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
                                mensaje = "Ambos habéis sacado tijera, habeis empatado";
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

        switch (nPartidas){
            case 0:
                SacarMensaje.sacarVentana("Loki te ha bajado las defensas de tus súbditos en un 5%");
                for(Subditos elemento: equipo){
                    elemento.setDefensa((int) (elemento.getDefensa()*0.95)); //bajar las defensas de los súbditos 5%
                }
                break;
            case 1:
                opcion = SacarMensaje.pedirOpciones("El ángel te recompensa con subirle el ataque a un súbdito\n¿A quien quieres subirle el ataque?",nEquipos);
                equipo.get(opcion).setAtaque((int) (equipo.get(opcion).getAtaque()*1.05));
                break;
            case 2:
                opcion = SacarMensaje.pedirOpciones("El ángel te recompensa con subirle la vida a un súbdito\n¿A quien quieres subirle la vida?",nEquipos);
                equipo.get(opcion).setVida((int) (equipo.get(opcion).getVida()+10));
                break;
            case 3:
                SacarMensaje.sacarVentana("El ángel te recompensa con subirle el ataque y la defensa a dos súbditos\n");
                opcion = SacarMensaje.pedirOpciones("¿A quien quieres subirle el ataque y la defensa?",nEquipos);
                equipo.get(opcion).setAtaque((int) (equipo.get(opcion).getAtaque()*1.1));equipo.get(opcion).setDefensa((int) (equipo.get(opcion).getDefensa()*1.1));

                //segundo a subir
                do {
                    opcion2 = SacarMensaje.pedirOpciones("¿A quien quieres subirle el ataque y la defensa?", nEquipos);
                    if(opcion2!=opcion) {
                        equipo.get(opcion2).setAtaque((int) (equipo.get(opcion2).getAtaque() * 1.1));
                        equipo.get(opcion2).setDefensa((int) (equipo.get(opcion2).getDefensa() * 1.1));
                    }else{
                        SacarMensaje.sacarVentana("No juegues conmigo, he dicho 2 súbditos no solo 1");
                    }
                }while (opcion2==opcion);
                break;
        }
    }
}

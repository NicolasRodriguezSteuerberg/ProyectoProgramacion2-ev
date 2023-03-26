package Batallas;

import Datos.Ficheros;
import Datos.Libreria;
import Historia.Final;
import Personajes.Bosses;
import Personajes.Subditos;
import com.nicosteuerberg.datos.PedirDatos;
import com.nicosteuerberg.datos.SacarMensaje;

import java.io.File;
import java.util.ArrayList;

public class BatallaFinal {
    public static void calcularAtqEq(ArrayList<Subditos> equipo, ArrayList<Bosses>boss, int nroSubdito, int nroBoss, int op_eq){
        SacarMensaje.sacarVentana(equipo.get(nroSubdito).getMensaje());
        if(op_eq!=0) {
            int atqEq = (int) ((2.55 * (op_eq / (boss.get(nroBoss).getDefensa() * 25) + 2)) / boss.get(nroBoss).getResistenciaAtaque());
            boss.get(nroBoss).setVida(boss.get(nroBoss).getVida() - atqEq);
        }
    }

    public static void calcularAtqRiv(ArrayList<Subditos>equipo, ArrayList<Bosses>boss, int nroSubdito,int nroBoss, int op_riv){
        int atqRiv = (int) ((2.55 * (op_riv / (equipo.get(nroSubdito).getDefensa() * 25) + 2)) / equipo.get(nroSubdito).getResistenciaAtaque());
        equipo.get(nroSubdito).setVida(equipo.get(nroSubdito).getVida() - atqRiv);
    }

    public static void batallaBoss(ArrayList<Subditos>equipo){
        //lectura bosses final
        ArrayList<Bosses> boss= new ArrayList();
        Ficheros obxFicheros = new Ficheros();
        File bo = new File("bossFinal.txt");
        boss = obxFicheros.lerFicheroBoss(bo);

        //declaraciones
        int flag, flagD, movElegido, bossAtacado;
        String opcionesAtaques[] = {boss.get(0).getNombre(), boss.get(1).getNombre()};

        /* Poner audio nico + foto gabri
        SacarMensaje.sacarVentana(boss.get(nroBoss).getNombre() + " tiene algo que decirte antes de la pelea:");
        Libreria.audioP(nroBoss);
        */

        //reiniciar la resistencia al ataque
        for(int i = 0; i < equipo.size(); i++){
            if(equipo.get(i).getResistenciaAtaque()!=1){
                equipo.get(i).setResistenciaAtaque(1);
            }
        }


        //ataque Loki
        SacarMensaje.sacarVentana("Loki el tramposo ataca sin que te de tiempo a reaccionar");
        int numero = Libreria.numeroRandom(0,(equipo.size()-1));
        movElegido=boss.get(1).movimientos();
        calcularAtqRiv(equipo,boss,numero,1,movElegido);
        SacarMensaje.sacarVentana(equipo.get(numero).getVida() + "PS");
        SacarMensaje.sacarVentana(equipo.get(numero).getNombre() + " ha muerto por las trampas de Loki");

        //empieza la verdadera pelea
        do{
            flag=0;
            flagD=0;

            //ataque de los súbditos
            for (int i=0; i<equipo.size();i++){
                if(equipo.get(i).getVida()>0 && boss.get(0).getVida()>0 || equipo.get(i).getVida()>0 && boss.get(1).getVida()>0){
                    movElegido=equipo.get(i).movimientos(1);
                    if(movElegido==0){
                        SacarMensaje.sacarVentana(equipo.get(i).getMensaje());
                        flagD=1;
                    }else {
                        if(boss.get(1).getVida()>0) {
                            bossAtacado = SacarMensaje.pedirOpciones("¿A quien quieres atacar?",opcionesAtaques);
                        }
                        else{
                            bossAtacado = 0;
                        }
                        calcularAtqEq(equipo, boss, i, bossAtacado, movElegido);

                        //mensaje de si el boss atacado muere o la vida a la que se ha quedado
                        if(boss.get(bossAtacado).getVida()>0) {
                            SacarMensaje.sacarVentana(boss.get(bossAtacado).getNombre() + " se ha quedado a " + boss.get(bossAtacado).getVida());
                        }else{
                            SacarMensaje.sacarVentana(boss.get(bossAtacado).getNombre() + " ha muerto...");
                        }
                    }
                }
            }

            //ataque rival
            for(int nroBoss = 0; nroBoss < boss.size(); nroBoss++){
                if (boss.get(nroBoss).getVida()>0) {
                    movElegido = boss.get(nroBoss).movimientos();
                    SacarMensaje.sacarVentana(boss.get(nroBoss).getMensaje());

                    //si alguien se defiende
                    if (flagD == 1) {
                        for (int i = 0; i < equipo.size(); i++) {
                            if (equipo.get(i).getVida() > 0 && equipo.get(i).getResistenciaAtaque() != 1) {
                                calcularAtqRiv(equipo, boss, i, nroBoss, movElegido);
                                if (equipo.get(i).getVida() > 0) {
                                    flag = 1;
                                    SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(i).getNombre() + " se ha quedado a " + equipo.get(i).getVida());
                                } else {
                                    SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(i).getNombre() + " ha muerto...");
                                }
                            } else if (equipo.get(i).getVida() > 0) {
                                flag = 1;
                            }
                        }

                    //si nadie se defiende
                    } else {
                        for (int i = 0; i < equipo.size(); i++) {
                            if (equipo.get(i).getVida() > 0) {
                                calcularAtqRiv(equipo, boss, i, nroBoss, movElegido);

                                if (equipo.get(i).getVida() > 0) {
                                    SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(i).getNombre() + " se ha quedado a " + equipo.get(i).getVida());
                                    flag = 1;
                                } else {
                                    SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(i).getNombre() + " ha muerto...");
                                }
                            }
                        }
                    }
                }

            }

        } while((boss.get(0).getVida()>0 || boss.get(1).getVida()>0) && flag==1);


        //finales alternativos
        if(boss.get(0).getVida()>0 || boss.get(1).getVida()>0){
            SacarMensaje.sacarVentana("Tus alumnos se han vengado");
            Final.finalHistoria();

        }else{
            SacarMensaje.sacarVentana("Te parecerá bonito, además de haberles suspendido por la cara, les matas\nFutura denuncia que se te viene encima");
            SacarMensaje.sacarVentana("FIN DE LA HISTORIA");
            System.exit(0);
        }

    }

}

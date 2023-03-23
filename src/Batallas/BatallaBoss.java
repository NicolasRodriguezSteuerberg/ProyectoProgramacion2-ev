package Batallas;

import Datos.Libreria;
import Personajes.Bosses;
import Personajes.Subditos;
import com.nicosteuerberg.datos.PedirDatos;
import com.nicosteuerberg.datos.SacarMensaje;

import javax.swing.*;
import java.util.ArrayList;

public class BatallaBoss {


    public static void calcularAtqEq(ArrayList<Subditos> equipo, ArrayList<Bosses>boss, int nroSubdito,int nroBoss, int op_eq){
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

    public static void batallaBoss(ArrayList<Subditos>equipo,ArrayList<Bosses>boss,int nroBoss){
        int movElegido;
        int flag, flagD, opc;
        int auxVidas[]=new int [equipo.size()];
        int auxVidaBoss = boss.get(nroBoss).getVida();

        for(int i=0;i<equipo.size();i++){
            auxVidas[i]=equipo.get(i).getVida();
        }
        SacarMensaje.sacarVentana("Ha llegado la hora. Estas preparado para enfrentarte a: "+boss.get(nroBoss).getNombre());

        do{
            flag=0;
            flagD=0;

            //los subditos atacan primero:
            for (int i=0; i<equipo.size();i++){
                if(equipo.get(i).getVida()>0 && boss.get(nroBoss).getVida()>0){
                    movElegido=equipo.get(i).movimientos(1);
                    if(movElegido==0){
                        flagD=1;
                    }else {
                        calcularAtqEq(equipo, boss, i, nroBoss, movElegido);
                        if(boss.get(nroBoss).getVida()>0) {
                            SacarMensaje.sacarVentana(boss.get(nroBoss).getNombre() + " se ha quedado a " + boss.get(nroBoss).getVida());
                        }else{
                            SacarMensaje.sacarVentana(boss.get(nroBoss).getNombre() + " ha muerto...");
                        }
                    }
                }
            }

            if (boss.get(nroBoss).getVida()>0){
                movElegido=boss.get(nroBoss).movimientos();
                SacarMensaje.sacarVentana(boss.get(nroBoss).getMensaje());

                //si alguien se defiende
                if(flagD==1){
                    for(int i=0;i<equipo.size();i++){
                        if(equipo.get(i).getVida()>0 && equipo.get(i).getResistenciaAtaque()!=1){
                            calcularAtqRiv(equipo,boss,i,nroBoss,movElegido);
                            if(equipo.get(i).getVida()>0){
                                flag=1;
                                SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(i).getNombre() + " se ha quedado a " + equipo.get(i).getVida());
                            }else{
                                SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(i).getNombre() + " ha muerto...");
                            }
                        }
                        else if (equipo.get(i).getVida()>0){
                            flag=1;
                        }
                    }

                //si nadie se defiende
                }else {
                    for(int i=0;i<equipo.size();i++){
                        if(equipo.get(i).getVida()>0){
                            calcularAtqRiv(equipo,boss,i,nroBoss,movElegido);

                            if(equipo.get(i).getVida()>0){
                                SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(i).getNombre() + " se ha quedado a " + equipo.get(i).getVida());
                                flag=1;
                            }else{
                                SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(i).getNombre() + " ha muerto...");
                            }
                        }
                    }
                }

            }

        } while(boss.get(nroBoss).getVida()>0 && flag==1);

        Libreria.reiniciarVidas(equipo,auxVidas);

        if(boss.get(0).getVida()>0){
            do {
                try {
                    opc = PedirDatos.getInt("Lo siento. Has perdido..." + "\n" +
                            "1 -> Reintentar" + "\n" +
                            "2 -> Salir del juego");
                } catch (Exception e) {
                    SacarMensaje.sacarVentana("Error en la inserción del número");
                    opc = 4;
                }
                if(opc==1){
                    boss.get(nroBoss).setVida(auxVidaBoss);
                    boss.get(nroBoss).setEnergia(0);
                    batallaBoss(equipo,boss,nroBoss);
                }
                else if(opc==2){
                    SacarMensaje.sacarVentana("Saliendo del programa...");
                    System.exit(0);
                }
            }while(opc>2 || opc<1);
        }else{
            SacarMensaje.sacarVentana("Buen trabajo, has ganado la batalla.\n" + boss.get(0).getNombre() + " (rival) ha muerto");
        }

    }

}

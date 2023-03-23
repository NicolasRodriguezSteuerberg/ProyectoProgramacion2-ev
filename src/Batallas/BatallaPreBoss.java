package Batallas;

import Datos.Libreria;
import Personajes.Personajes;
import Personajes.Subditos;
import com.nicosteuerberg.datos.PedirDatos;
import com.nicosteuerberg.datos.SacarMensaje;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BatallaPreBoss{


    public static void añadirRival(ArrayList<Subditos> rivales,ArrayList<Subditos> personajes){
        int numero = Libreria.numeroRandom(0,(personajes.size()-1));
        rivales.get(0).setVida(personajes.get(numero).getVida());
        rivales.get(0).setAtaque(personajes.get(numero).getAtaque());
        rivales.get(0).setDefensa(personajes.get(numero).getDefensa());
        rivales.get(0).setVelocidad(personajes.get(numero).getVelocidad());
        rivales.get(0).setNombre(personajes.get(numero).getNombre());
        rivales.get(0).setElemento(personajes.get(numero).getElemento());
        rivales.get(0).setNivel(personajes.get(numero).getNivel());
        rivales.get(0).setEnergia(1);
    }
    public static void calcularAtqRiv(ArrayList<Subditos>equipo, ArrayList<Subditos>rival,int nroSubdito, int op_riv){
        SacarMensaje.sacarVentana(rival.get(0).getMensaje());
            int atqRiv = (int) ((2.55 * (op_riv / (equipo.get(nroSubdito).getDefensa() * 25) + 2)) / equipo.get(nroSubdito).getResistenciaAtaque());
            equipo.get(nroSubdito).setVida(equipo.get(nroSubdito).getVida() - atqRiv);
    }

    public static void calcularAtqEq(ArrayList<Subditos>equipo, ArrayList<Subditos>rival,int nroSubdito, int op_eq){
        SacarMensaje.sacarVentana(equipo.get(nroSubdito).getMensaje());
        if(op_eq!=0) {
            int atqEq = (int) ((2.55 * (op_eq / (rival.get(0).getDefensa() * 25) + 2)) / rival.get(0).getResistenciaAtaque());
            rival.get(0).setVida(rival.get(0).getVida() - atqEq);
        }
    }

    public static void batallaNormal(ArrayList<Subditos> equipo, ArrayList<Subditos>rival,ArrayList<Subditos> personajes){
        Integer opc=null;
        int nroSubdito=0;
        int auxVida[] = new int[4];
        añadirRival(rival,personajes);

        SacarMensaje.sacarVentana("Siguiendo tu aventura te encuentras a otro rival\nTe enfrentarás contra: "+rival.get(0).getNombre());

    do{
        auxVida[nroSubdito]=equipo.get(nroSubdito).getVida();

        do{
            int op_eq=equipo.get(nroSubdito).movimientos(1);
            int op_riv=rival.get(0).movimientos(Personajes.RIVAL);

            //Si el rival ataca primero:
            if (equipo.get(nroSubdito).getVelocidad()<=rival.get(0).getVelocidad()){
                calcularAtqRiv(equipo,rival,nroSubdito,op_riv);

                if(equipo.get(nroSubdito).getVida()>0){
                    SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(nroSubdito).getNombre() + " se ha quedado a " + equipo.get(nroSubdito).getVida());
                    calcularAtqEq(equipo,rival,nroSubdito,op_eq);

                    if(rival.get(0).getVida()>0 && op_eq!=0){
                        SacarMensaje.sacarVentana(rival.get(0).getNombre() + " (rival) se ha quedado a " + rival.get(0).getVida());
                    }
                }

            }else{ //Si el subdito ataca primero:
                calcularAtqEq(equipo,rival,nroSubdito,op_eq);

                if(rival.get(0).getVida()>0){
                    if(op_eq!=0) {
                        SacarMensaje.sacarVentana(rival.get(0).getNombre() + " (rival) se ha quedado a " + rival.get(0).getVida());
                    }
                    calcularAtqRiv(equipo, rival, nroSubdito, op_riv);

                    if(equipo.get(nroSubdito).getVida()>0){
                        SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(nroSubdito).getNombre() + " se ha quedado a " + equipo.get(nroSubdito).getVida());
                    }
                }
            }
        }while(equipo.get(nroSubdito).getVida()>0 && rival.get(0).getVida()>0);

        if(equipo.get(nroSubdito).getVida()<=0){
            SacarMensaje.sacarVentana(equipo.get(nroSubdito).getNombre()+" ha muerto.");
            nroSubdito++;
        }

        /*AQUI LLAMAR AL METODO PARA REINICIAR VIDA Y ENERGÍA
        * */

        Libreria.reiniciarVidas(equipo,auxVida);


    }while(equipo.size()>nroSubdito && rival.get(0).getVida()>0);

    if(rival.get(0).getVida()>0){
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
                batallaNormal(equipo,rival,personajes);
            }
            else if(opc==2){
                SacarMensaje.sacarVentana("Saliendo del programa...");
                System.exit(0);
            }
        }while(opc>2 || opc<1);
    }else{
        SacarMensaje.sacarVentana("Buen trabajo, has ganado la batalla.\n" + rival.get(0).getNombre() + " (rival) ha muerto");
    }



    }
}

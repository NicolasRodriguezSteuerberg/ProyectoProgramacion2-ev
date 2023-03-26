package Batallas;

import Datos.Libreria;
import Personajes.*;

import javax.swing.*;
import java.util.ArrayList;
import com.nicosteuerberg.datos.*;

public class Tutorial {

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
    public static void calcularAtqRiv(ArrayList<Subditos>equipo, ArrayList<Subditos>rival, int op_riv){
        SacarMensaje.sacarVentana(rival.get(0).getMensaje());
        if(op_riv!=0) {
            int atqRiv = (int) ((2.55 * (op_riv / (equipo.get(0).getDefensa() * 25) + 2)) / equipo.get(0).getResistenciaAtaque());
            equipo.get(0).setVida(equipo.get(0).getVida() - atqRiv);
        }
    }

    public static void calcularAtqEq(ArrayList<Subditos>equipo, ArrayList<Subditos>rival, int op_eq){
        SacarMensaje.sacarVentana(equipo.get(0).getMensaje());
        if(op_eq!=0) {
            int atqEq = (int) ((2.55 * (op_eq / (rival.get(0).getDefensa() * 25) + 2)) / rival.get(0).getResistenciaAtaque());
            rival.get(0).setVida(rival.get(0).getVida() - atqEq);
        }
    }

    public static void primeraBatalla(ArrayList<Subditos>equipo,ArrayList<Subditos>rival,ArrayList<Subditos>personajes){
        añadirRival(rival,personajes);
       SacarMensaje.sacarVentana("Bienvenido a tu primera batalla. Veamos las opciones que tienes:\n" +
               "Atacar -> Atacas al rival (movimiento común)\n" +
               "Defender -> El daño del rival hacia ti se reduce (movimiento común)\n" +
               "Movimiento especial -> Característico del elemento, siendo más potente que 'Atacar' (necesitas 3 de energía para poder usarlo)");
        Integer opc=null;



        int atqEq,atqRiv;
        int auxVida=equipo.get(0).getVida();

       do{
           if(equipo.get(0).getEnergia()==3){
              SacarMensaje.sacarVentana("Enhorabuena!, ya tienes la energía suficiente para usar tu movimiento especial");
           }

           int op_eq=equipo.get(0).movimientos(1);
           int op_riv=rival.get(0).movimientos(Personajes.RIVAL);

           //Si el rival ataca primero:
           if (equipo.get(0).getVelocidad()<=rival.get(0).getVelocidad()){
               calcularAtqRiv(equipo,rival,op_riv);

               if(equipo.get(0).getVida()>0){
                   SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(0).getNombre() + " se ha quedado a " + equipo.get(0).getVida());
                   calcularAtqEq(equipo,rival,op_eq);

                   if(rival.get(0).getVida()>0 && op_eq!=0) {
                       SacarMensaje.sacarVentana(rival.get(0).getNombre() + " (rival) se ha quedado a " + rival.get(0).getVida());
                   }
               }

           }else{ //Si el subdito ataca primero:
               calcularAtqEq(equipo,rival,op_eq);

               if(rival.get(0).getVida()>0){
                   if(op_eq!=0) {
                       SacarMensaje.sacarVentana(rival.get(0).getNombre() + " (rival) se ha quedado a " + rival.get(0).getVida());
                   }
                   calcularAtqRiv(equipo,rival,op_riv);

                   if(equipo.get(0).getVida()>0){
                       SacarMensaje.sacarVentana("Tu súbdito: " + equipo.get(0).getNombre() + " se ha quedado a " + equipo.get(0).getVida());
                   }
               }

           }
       }while(equipo.get(0).getVida()>0 && rival.get(0).getVida()>0);

        Libreria.reiniciarVida(equipo,0,auxVida);

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
                    primeraBatalla(equipo,rival,personajes);
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
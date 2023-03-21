package Batallas;

import Personajes.*;

import javax.swing.*;
import java.util.ArrayList;
import com.nicosteuerberg.datos.*;

public class Tutorial {

    int opc;

    public void calcularAtqRiv(ArrayList<Subditos>equipo, ArrayList<Subditos>rival, int op_riv){
        SacarMensaje.sacarVentana(rival.get(0).getMensaje());
        int atqRiv= (int) ((2.55*(op_riv/(equipo.get(0).getDefensa()*25)+2))/equipo.get(0).getResistenciaAtaque());
        equipo.get(0).setVida(equipo.get(0).getVida()-atqRiv);
    }

    public void calcularAtqEq(ArrayList<Subditos>equipo, ArrayList<Subditos>rival, int op_eq){
        SacarMensaje.sacarVentana(equipo.get(0).getMensaje());
        int atqEq= (int) ((2.55*(op_eq/(rival.get(0).getDefensa()*25)+2))/rival.get(0).getResistenciaAtaque());
        rival.get(0).setVida(rival.get(0).getVida()-atqEq);
    }

    public int primeraBatalla(ArrayList<Subditos>equipo,ArrayList<Subditos>rival){
        JOptionPane.showMessageDialog(null,"Bienvenido a tu primera batalla. Veamos las opciones que tienes");




        int atqEq,atqRiv;
        int auxVida=equipo.get(0).getVida();

       do{
           if(equipo.get(0).getEnergia()==3){
               JOptionPane.showMessageDialog(null,"Enhorabuena!, ya tienes la energía suficiente para usar tu movimiento especial");
           }

           int op_eq=equipo.get(0).movimientos();
           int op_riv=rival.get(0).movimientos();

           //Si el rival ataca primero:

           if (equipo.get(0).getVelocidad()<=rival.get(0).getVelocidad()){
               calcularAtqRiv(equipo,rival,op_riv);

               if(equipo.get(0).getVida()>0){
                   calcularAtqEq(equipo,rival,op_eq);
               }

           }else{ //Si el subdito ataca primero:

               calcularAtqEq(equipo,rival,op_eq);

               if(rival.get(0).getVida()>0){
                   calcularAtqRiv(equipo,rival,op_riv);
               }
           }
       }while(equipo.get(0).getVida()>0 || rival.get(0).getVida()>0);

       if(equipo.get(0).getVida()<=0){
           opc=PedirDatos.getInt("Lo siento. Has perdido..."+"\n"+
                   "1 -> Reintentar"+"\n"+
                   "2 -> Salir del juego");
       }else{
           SacarMensaje.sacarVentana("Buen trabajo, has ganado tu primera batalla.");
           opc=3;
       }

       Libreria.reiniciarVida(equipo,0,auxVida);

        return opc; //opc 1. Repetir el método "primera batalla", opc 2. Salir del programa, opc 3. Continuar con la historia
    }


}
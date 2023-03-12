package Batallas;

import Personajes.*;

import javax.swing.*;
import java.util.ArrayList;
import com.nicosteuerberg.datos.*;

public class Tutorial {

    int opc;

    public int primeraBatalla(ArrayList<Subditos>equipo,ArrayList<Subditos>rival){
        JOptionPane.showMessageDialog(null,"Bienvenido a tu primera batalla. Veamos las opciones que tienes");

        Integer op1_eq=equipo.get(0).movimientos();
        Integer op1_riv=rival.get(0).movimientos();


        int atqEq,atqRiv;
        int auxVida=equipo.get(0).getVida();

       do{
           if(equipo.get(0).getEnergia()==3){
               JOptionPane.showMessageDialog(null,"Enhorabuena!, ya tienes la energía suficiente para usar tu movimiento especial");
           }

           //Si el rival ataca primero:

           if (equipo.get(0).getVelocidad()<=rival.get(0).getVelocidad()){
               JOptionPane.showMessageDialog(null,rival.get(0).getMensaje());
               atqRiv= (int) ((2.55*(op1_riv/(equipo.get(0).getDefensa()*25)+2))/equipo.get(0).getResistenciaAtaque());
               equipo.get(0).setVida(equipo.get(0).getVida()-atqRiv);

               if(equipo.get(0).getVida()>0){
                   JOptionPane.showMessageDialog(null,equipo.get(0).getMensaje());
                   atqEq= (int) ((2.55*(op1_eq/(rival.get(0).getDefensa()*25)+2))/rival.get(0).getResistenciaAtaque());
                   rival.get(0).setVida(rival.get(0).getVida()-atqEq);
               }

           }else{ //Si el subdito acata primero:

               JOptionPane.showMessageDialog(null,equipo.get(0).getMensaje());
               atqEq= (int) ((2.55*(op1_eq/(rival.get(0).getDefensa()*25)+2))/rival.get(0).getResistenciaAtaque());
               rival.get(0).setVida(rival.get(0).getVida()-atqEq);

               if(rival.get(0).getVida()>0){
                   JOptionPane.showMessageDialog(null,rival.get(0).getMensaje());
                   atqRiv= (int) ((2.55*(op1_riv/(equipo.get(0).getDefensa()*25)+2))/equipo.get(0).getResistenciaAtaque());
                   equipo.get(0).setVida(equipo.get(0).getVida()-atqRiv);
               }
           }
       }while(equipo.get(0).getVida()>0 || rival.get(0).getVida()>0);

       if(equipo.get(0).getVida()<=0){
           opc=PedirDatos.getInt("Lo siento. Has perdido..."+"\n"+
                   "1 -> Reintentar"+"\n"+
                   "2 -> Salir del juego");
       }else{
           JOptionPane.showMessageDialog(null,"Buen trabajo, has ganado tu primera batalla.");
           opc=3;
       }

        return opc; //opc 1. Repetir el método "primera batalla", opc 2. Salir del programa, opc 3. Continuar con la historia
    }
}
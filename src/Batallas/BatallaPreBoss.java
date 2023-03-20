package Batallas;

import Personajes.Subditos;
import com.nicosteuerberg.datos.PedirDatos;
import com.nicosteuerberg.datos.SacarMensaje;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BatallaPreBoss{

    public void calcularAtqRiv(ArrayList<Subditos>equipo, ArrayList<Subditos>rival,int nroSubdito, int op_riv){
        JOptionPane.showMessageDialog(null,rival.get(0).getMensaje());
        int atqRiv= (int) ((2.55*(op_riv/(equipo.get(nroSubdito).getDefensa()*25)+2))/equipo.get(nroSubdito).getResistenciaAtaque());
        equipo.get(nroSubdito).setVida(equipo.get(nroSubdito).getVida()-atqRiv);
    }

    public void calcularAtqEq(ArrayList<Subditos>equipo, ArrayList<Subditos>rival,int nroSubdito, int op_eq){
        JOptionPane.showMessageDialog(null,equipo.get(nroSubdito).getMensaje());
        int atqEq= (int) ((2.55*(op_eq/(rival.get(0).getDefensa()*25)+2))/rival.get(0).getResistenciaAtaque());
        rival.get(0).setVida(rival.get(0).getVida()-atqEq);
    }

    public int batallaNormal(ArrayList<Subditos> equipo, ArrayList<Subditos>rival){

    int nroSubdito=0;
    int opc;

    do{
        int auxVida=equipo.get(nroSubdito).getVida();
        Integer op_eq=equipo.get(nroSubdito).movimientos();
        Integer op_riv=rival.get(0).movimientos();
        do{

            //Si el rival ataca primero:

            if (equipo.get(nroSubdito).getVelocidad()<=rival.get(0).getVelocidad()){
                calcularAtqRiv(equipo,rival,nroSubdito,op_riv);

                if(equipo.get(nroSubdito).getVida()>0){
                calcularAtqEq(equipo,rival,nroSubdito,op_eq);
                }

            }else{ //Si el subdito ataca primero:

                calcularAtqEq(equipo,rival,nroSubdito,op_eq);

                if(rival.get(0).getVida()>0){
                    calcularAtqRiv(equipo,rival,nroSubdito,op_riv);
                }
            }
        }while(equipo.get(nroSubdito).getVida()>0 || rival.get(0).getVida()>0);

        if(equipo.get(nroSubdito).getVida()<=0){
            SacarMensaje.sacarVentana(equipo.get(nroSubdito).getNombre()+" ha muerto.");
            equipo.get(nroSubdito).setVida(auxVida);
            nroSubdito++;
        }

    }while(equipo.size()<nroSubdito || rival.get(0).getVida()>0);

    if(rival.get(0).getVida()>0){
        opc=PedirDatos.getInt("Lo siento. Has perdido..."+"\n"+
                "1 -> Reintentar"+"\n"+
                "2 -> Salir del juego");
    }else{
        SacarMensaje.sacarVentana("Buen trabajo, has ganado! Suerte en tu próxima aventura (la necesitarás)");
        opc=3;
    }
    return opc;
    }
}

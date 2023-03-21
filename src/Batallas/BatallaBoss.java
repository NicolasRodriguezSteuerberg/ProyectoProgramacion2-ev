package Batallas;

import Personajes.Bosses;
import Personajes.Subditos;
import com.nicosteuerberg.datos.PedirDatos;
import com.nicosteuerberg.datos.SacarMensaje;

import javax.swing.*;
import java.util.ArrayList;

public class BatallaBoss {

    int auxVidas[]=new int [4];
    int opc;
    public void calcularAtqEq(ArrayList<Subditos> equipo, ArrayList<Bosses>boss, int nroSubdito,int nroBoss, int op_eq){
        SacarMensaje.sacarVentana(equipo.get(nroSubdito).getMensaje());
        int atqEq= (int) ((2.55*(op_eq/(boss.get(nroBoss).getDefensa()*25)+2))/boss.get(nroBoss).getResistenciaAtaque());
        boss.get(nroBoss).setVida(boss.get(nroBoss).getVida()-atqEq);
    }

    public void calcularAtqRiv(ArrayList<Subditos>equipo, ArrayList<Bosses>boss, int nroSubdito,int nroBoss, int op_riv){
        SacarMensaje.sacarVentana(boss.get(nroBoss).getMensaje());
        int atqRiv= (int) ((2.55*(op_riv/(equipo.get(nroSubdito).getDefensa()*25)+2))/equipo.get(nroSubdito).getResistenciaAtaque());
        equipo.get(nroSubdito).setVida(equipo.get(nroSubdito).getVida()-atqRiv);
    }

    public int batallaBoss(ArrayList<Subditos>equipo,ArrayList<Bosses>boss,int nroBoss){
        int movElegido;
        int flag;

        for(int i=0;i<equipo.size();i++){
            auxVidas[i]=equipo.get(i).getVida();
        }


        do{
            flag=0;
            for (int i=0; i<equipo.size();i++){
                if(equipo.get(i).getVida()>0 && boss.get(nroBoss).getVida()>0){
                    movElegido=equipo.get(i).movimientos();
                    calcularAtqEq(equipo,boss,i,nroBoss,movElegido);
                }
            }

            if (boss.get(nroBoss).getVida()>0){
                movElegido=boss.get(nroBoss).movimientos();

                for(int i=0;i<equipo.size();i++){
                    if(equipo.get(i).getVida()>0){
                        calcularAtqRiv(equipo,boss,i,nroBoss,movElegido);

                        if(equipo.get(i).getVida()>0){
                            flag=1;
                        }
                    }
                }
            }

        } while(boss.get(nroBoss).getVida()>0 || flag==0);

        Libreria.reiniciarVidas(equipo,auxVidas);

        if(boss.get(nroBoss).getVida()>0){
            opc= PedirDatos.getInt("Lo siento. Has perdido..."+"\n"+
                    "1 -> Reintentar"+"\n"+
                    "2 -> Salir del juego");
        }else{
            SacarMensaje.sacarVentana("Enhorabuena, has destrozado a tu rival. \nSigue con tu aventura, cada vez estás más cerca de lograr tu objetivo!");
            opc=3;
        }

        return opc;
    }

}

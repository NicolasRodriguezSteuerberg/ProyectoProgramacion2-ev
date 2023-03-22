package Datos;

import Personajes.Bosses;
import Personajes.Subditos;
import com.nicosteuerberg.datos.SacarMensaje;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ficheros{
    Scanner sc = null;

    //subditos generales y súbditos personajes
    public ArrayList<Subditos> lerFicheroSubditos(File e){
        String aux[] = new String[9];
        ArrayList<Subditos> subd = new ArrayList();
        try {
            sc = new Scanner(e);
            while (sc.hasNextLine()){
                aux = sc.nextLine().split("\\s*,\\s*");
                subd.add(new Subditos(aux[0],aux[1],aux[2],Integer.parseInt(aux[3]),Integer.parseInt(aux[4]),Integer.parseInt(aux[5]),Integer.parseInt(aux[6]),Integer.parseInt(aux[7]),Integer.parseInt(aux[8]),null,1));
            }
        } catch (FileNotFoundException ex) {
            SacarMensaje.sacarVentana("Error fichero de súbditos no encontrado");
        }
        finally {
            sc.close();
        }
        return subd;
    }


    public ArrayList<Bosses> lerFicheroBoss(File e){
        String aux[] = new String[10];
        ArrayList<Bosses> boss = new ArrayList();
        try {
            sc = new Scanner(e);
            while (sc.hasNextLine()){
                aux = sc.nextLine().split("\\s,\\s");
                boss.add(new Bosses(aux[0],aux[1],aux[2],Integer.parseInt(aux[3]),Integer.parseInt(aux[4]),Integer.parseInt(aux[5]),Integer.parseInt(aux[6]),Integer.parseInt(aux[7]),Integer.parseInt(aux[8]),null,Integer.parseInt(aux[9])));
            }
        } catch (FileNotFoundException ex) {
            SacarMensaje.sacarVentana("Error fichero de boss no encontrado");
        }
        finally {
            sc.close();
        }
        return boss;
    }
}

package Historia;

import Batallas.BatallaBoss;
import Batallas.BatallaPreBoss;
import Batallas.Tutorial;
import Datos.Ficheros;
import Datos.Libreria;
import Personajes.Bosses;
import Personajes.Subditos;
import com.nicosteuerberg.datos.SacarMensaje;

import java.io.File;
import java.util.ArrayList;

public class Infierno {


    public static void subirNiveles(ArrayList<Subditos> equipo, ArrayList<Subditos> personajes){
        Subditos.subirNivel(equipo);
        Subditos.subirNivel(personajes);
        SacarMensaje.sacarVentana("Felicidades has subido de nivel");
    }

    public static void infierno(){
        int opcionSeleccion;
        //arrays
        ArrayList<Subditos> equipo = new ArrayList();
        ArrayList<Subditos> seleccion = new ArrayList();
        ArrayList<Subditos> personajes = new ArrayList();
        ArrayList<Subditos> rivales = new ArrayList();
        ArrayList<Bosses> bosses= new ArrayList();
        rivales.add(new Subditos("","","",0,0,0,0,1,0,"",0));

        //leer ficheros
        Ficheros obxFicheros = new Ficheros();

        //lectura de todos los bosses
        File bo = new File("boss.txt");
        bosses = obxFicheros.lerFicheroBoss(bo);

        //lectura de todos los súbditos/rivales
        File pers = new File("subditos.txt");
        personajes = obxFicheros.lerFicheroSubditos(pers);

        //selección personaje principal de tu equipo
        File principales = new File("principales.txt");
        seleccion = obxFicheros.lerFicheroSubditos(principales);
        String opcionesSeleccion[] = new String[3];

        //opciones a elegir
        opcionesSeleccion[0] = seleccion.get(0).getNombre() + " " + seleccion.get(0).getElemento();
        opcionesSeleccion[1] = seleccion.get(1).getNombre() + " " + seleccion.get(1).getElemento();
        opcionesSeleccion[2] = seleccion.get(2).getNombre() + " " + seleccion.get(2).getElemento();

        //seleccion del primer subdito
        opcionSeleccion = SacarMensaje.pedirOpciones("Selecciona tu súbdito principal", opcionesSeleccion);
        equipo.add(seleccion.get(opcionSeleccion));
        SacarMensaje.sacarVentana("Felicidades, ahora tienes tu primer súbdito, estas son sus estadísticas:\n" + equipo.get(0).toString());

        SacarMensaje.sacarVentana("Nina para seguir su sueño se da cuenta que tendrá que luchar contra otros infernales\n"+
                "para ir aumentando el poder de su equipo y para conseguir más súbditos, además tendrá\n"+
                "que luchar contra Infernales de alto rango. De esta manera se encuentra a su primer enemigo.");

        Tutorial.primeraBatalla(equipo,rivales,personajes);
        subirNiveles(equipo,personajes);
        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);

        Libreria.añadirIntegrante(equipo,personajes);

        BatallaBoss.batallaBoss(equipo,bosses,0);

        subirNiveles(equipo,personajes);

        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);
        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);

        subirNiveles(equipo,personajes);

        Libreria.añadirIntegrante(equipo,personajes);

        BatallaBoss.batallaBoss(equipo,bosses,1);

        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);
        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);

        Libreria.añadirIntegrante(equipo,personajes);

        BatallaBoss.batallaBoss(equipo,bosses,2);

        subirNiveles(equipo,personajes);

        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);
        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);

        subirNiveles(equipo,personajes);

        BatallaBoss.batallaBoss(equipo,bosses,3);

        Subditos.evolucionar(equipo);

        //final infierno
        SacarMensaje.sacarVentana("Enhorabuena has ganado a todos los infernales y has conseguido\n"+
                "suficiente poder, por lo que has evolucionado a Princesa Demonio.\n"+
                "Tus súbditos han evolucionado ganando mucho poder.");

        /*Futuras actualizaciones
        SacarMensaje.sacarVentana("Todos los infernales quieren estar en tu equipo pero solo puedes tener 4.\n"+
                "Debes formar tu equipo para ponerte en marcha hacia el Cielo, en esta\n"+
                "etapa lucharás contra los dioses para lograr tu sueño");

         Cambio de equipo
         */

        Cielo.cielo(equipo);


    }
}

package Historia;

import Batallas.BatallaBoss;
import Batallas.BatallaPreBoss;
import Batallas.Tutorial;
import Datos.Ficheros;
import Datos.Libreria;
import Personajes.Subditos;
import com.nicosteuerberg.datos.PedirDatos;
import com.nicosteuerberg.datos.SacarMensaje;

import java.io.File;
import java.util.ArrayList;

public class Infierno {



    public static void añadirIntegrante(ArrayList<Subditos> equipo,ArrayList<Subditos> personajes){
        int numero;
        numero = Libreria.numeroRandom(0,(personajes.size()-1));
        for(int i=0;i<equipo.size();i++){
            if(personajes.get(numero).getNombre().equals(equipo.get(i).getNombre())){
                numero = Libreria.numeroRandom(0,(personajes.size()-1));
                i = 0;
            }
        }
        equipo.add(new Subditos(personajes.get(numero).getNombre(),personajes.get(numero).getElemento(),personajes.get(numero).getTipo(),personajes.get(numero).getVida(),personajes.get(numero).getAtaque(),personajes.get(numero).getDefensa(),personajes.get(numero).getVelocidad(),personajes.get(numero).getResistenciaAtaque(),1,"",personajes.get(numero).getNivel()));
    }

    public static void infierno(){
        int opcionSeleccion;
        //arrays
        ArrayList<Subditos> equipo = new ArrayList();
        ArrayList<Subditos> seleccion = new ArrayList();
        ArrayList<Subditos> personajes = new ArrayList();
        ArrayList<Subditos> rivales = new ArrayList();
        rivales.add(new Subditos("","","",0,0,0,0,1,0,"",0));

        //leer ficheros
        Ficheros obxFicheros = new Ficheros();

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
        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);

        /**ToDo
         * añadir nuevo personaje, subir nivel
         */
        SacarMensaje.sacarVentana("Enhorabuena, has subido al nivel 2, tu súbdito a subido de poder.\n"+
                "Además has conseguido fama, gracias a esto ---- se ha unido a tu equipo\n"+
                "Al aumentar tu poder el primer infernal se ha interesado en luchar contigo.");

        /**ToDo
         * Subir nivel pre batalla, Batallas boss, subir nivel post batalla
         */

        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);
        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);

        /**ToDo
         * Subir nivel pre batalla, Batallas boss, subir nivel post batalla
         */

        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);
        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);

        /**ToDo
         * Subir nivel pre batalla, Batallas boss, subir nivel post batalla
         */

        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);
        BatallaPreBoss.batallaNormal(equipo,rivales,personajes);

        /**ToDo
         * Subir nivel pre batalla, Batallas boss, subir nivel post batalla
         */

        //final infierno
        SacarMensaje.sacarVentana("Enhorabuena has ganado a todos los infernales y has conseguido\n"+
                "suficiente poder, por lo que has evolucionado a Princesa Demonio.\n"+
                "Tus súbditos han evolucionado ganando mucho poder.");

        SacarMensaje.sacarVentana("Todos los infernales quieren estar en tu equipo pero solo puedes tener 4.\n"+
                "Debes formar tu equipo para ponerte en marcha hacia el Cielo, en esta\n"+
                "etapa lucharás contra los dioses para lograr tu sueño");

        /**ToDo
         * Cambio de equipo
         */

        Cielo.cielo();


    }
}

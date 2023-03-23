package Datos;

import Personajes.Subditos;
import com.nicosteuerberg.datos.SacarMensaje;

import java.util.ArrayList;

public class Libreria {

    //Metodos random
    public static int numeroRandom(int minimo, int maximo){
        maximo++;
        int num = (int) (Math.random()*(maximo-minimo)+minimo);
        return num;
    }

    /**
     * @param minimo valor bajo a recibir
     * @param maximo valor máximo a recibir
     * @param porcentaje porcentaje de que sea el valor máximo
     * @return
     */
    public static int numeroRandomProbabilidad(int minimo, int maximo, int porcentaje){

        int num = (int) (Math.random()*101);//devuelve un valor entre 0 y 100
        if(num <= porcentaje){
            num = maximo;
        } else {
            num = minimo;
        }
        return num;
    }


    // Instrucciones
    public static void Instrucciones(){
        String [] opciones = {"Objetivo","Movimientos","Diferencia entre personajes", "Salir"};
        String [] opciones2 = {"Si","No"};
        int opcion;
        Integer opcion2=0;

        do {
            opcion = SacarMensaje.pedirOpciones("¿Que quieres saber sobre el juego?",opciones);
            switch (opcion){
                case 0:
                    SacarMensaje.sacarVentana("El objetivo del juego es convertirse en rey demonio. Hay 2 escenarios principales: Infierno y cielo\nEn el 1 escenario (infierno) tendrás que luchar contra 4 Infernales de rango superior(boses), antes de enfrentarte a un boss\npeleas contra 2 infernales de rango inferior, estos te dan experiencia para subir de nivel, lo que te da poder para obtener\nun nuevo súbdito, solo puedes tener 4 como máximo en tu equipo.\nAl finalizar este escenario se te permitirá cambiar tu equipo con todos los infernales inferiores, al elegir\nel nuevo equipo(si quieres) accedes al segundo escenario, el cielo, aquí tendrás que pelear con 3 dioses, al ganar\na los 3 habrás conseguido tu objetivo. Buena suerte en tu aventura");
                    opcion2 = SacarMensaje.pedirOpciones("¿Quieres saber algo más del juego?",opciones2);
                    break;
                case 1:
                    SacarMensaje.sacarVentana("Hay 3 movimientos en este juego:\n1->Atacar: es un ataque débil que hace daño al enemigo. Sube la energia en 1\n2->Defenderse: esto te permite que el ataque recibido sea menor. Sube la energia en 1\n3->Movimiento especial: es un ataque fuerte y único por cada elemento que solo se puede hacer cuando tienes 3 de energia. Energia inicial=1. Al realizarlo tu energia pasa a ser 1");
                    opcion2 = SacarMensaje.pedirOpciones("¿Quieres saber algo más del juego?",opciones2);
                    break;
                case 2:
                    SacarMensaje.sacarVentana("En este juego hay 4 elementos: Fuego, Rayo, Viento, Agua y Tierra:\nLos de fuego son los más ofensivos, en cambio son débiles ante los ataques\nLos de rayo son algo más debiles ofensivamente que los de fuego,en cambio, tienen algo más de aguante\nLos de viento son equilibrados en poder ofensivo y defensivo, pero son los más veloces\nLos de agua son débiles atacando pero tienen mayor poder defensivo\nLos de tierra son los más debiles atacando pero los más fuertes defensivamente\n\nA pesar de esto hay dos tipos en cada elemento: uno que es más ofensivo y otro más defensivo pero la diferencia no es mucha");
                    opcion2 = SacarMensaje.pedirOpciones("¿Quieres saber algo más del juego?",opciones2);
            }

        }while(opcion2==0);
    }


    // "Reiniciar estadisticas"
    public static void reiniciarVida(ArrayList<Subditos>equipo, int nroSubdito,int auxvida){
        equipo.get(nroSubdito).setVida(auxvida);
        equipo.get(nroSubdito).setEnergia(1);
    }

    public static void reiniciarVidas(ArrayList<Subditos>equipo, int auxvida[]){
        for (int i=0;i<equipo.size();i++){
            equipo.get(i).setVida(auxvida[i]);
            equipo.get(i).setEnergia(1);
        }
    }

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
        SacarMensaje.sacarVentana("Tu fama ha aumentado, por lo que " + equipo.get(equipo.size()-1).getNombre() + " se ha unido a tu equipo:\n" + equipo.get(equipo.size()-1).toString());
    }
}

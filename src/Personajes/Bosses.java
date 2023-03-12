package Personajes;

import Datos.Random;

public class Bosses extends Personajes{
    int escenario;
    /**
     * @param nombre
     * @param elemento          = fuego||rayo||viento||agua||tierra
     * @param tipo              = ofensivo||defensivo
     * @param vida
     * @param ataque
     * @param defensa
     * @param velocidad
     * @param resistenciaAtaque = sirve para que si se defienden en ese turno reciba menos daño
     * @param energia           = para saber si puede usar el movimiento especial
     * @param mensaje           = es el mensaje que utilizaremos en las clases batallas para que salga un mensaje del movimiento que hacen
     */
    public Bosses(String nombre, String elemento, String tipo, int vida, int ataque, int defensa, int velocidad, int resistenciaAtaque, int energia, String mensaje, int escenario) {
        super(nombre, elemento, tipo, vida, ataque, defensa, velocidad, resistenciaAtaque, energia, mensaje);
    }

    @Override
    public Integer movimientos() {
        Integer referencia = null; //referencia del poder ofensivo del movimiento
        if(energia<3){
            mensaje = nombre + " ha atacado";
            energia++;

        }
        else{
            if (escenario==1){
                mensaje = nombre + " ha usado evangelización\nVuelve a clase :(";
                referencia = 6 * ataque * Random.numeroRandom(80,110);
            }
            else{
                if(nombre.equalsIgnoreCase("Poseidón")){

                }
            }
        }
        return referencia;
    }
}

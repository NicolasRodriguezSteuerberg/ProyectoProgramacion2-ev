package Personajes;

//Clase de los personajes iniciales que se puede elegir solo 1
public class Principales extends Personajes{
    private int nivel;
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
    public Principales(String nombre, String elemento, String tipo, int vida, int ataque, int defensa, int velocidad, float resistenciaAtaque, int energia, String mensaje, int nivel) {
        super(nombre, elemento, tipo, vida, ataque, defensa, velocidad, resistenciaAtaque, energia, mensaje);
        this.nivel = nivel;
    }


}

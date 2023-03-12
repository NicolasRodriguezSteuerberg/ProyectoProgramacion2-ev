package Personajes;

//Clase de los personajes iniciales que se puede elegir solo 1
public class Rivales extends Personajes{
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
    public Rivales(String nombre, String elemento, String tipo, int vida, int ataque, int defensa, int velocidad, float resistenciaAtaque, int energia, String mensaje, int nivel) {
        super(nombre, elemento, tipo, vida, ataque, defensa, velocidad, resistenciaAtaque, energia, mensaje);
        this.nivel = nivel;
    }

    @Override
    public Integer movimientos() {
        Integer referencia = null;
        if(energia<3){
            referencia = 6 * 25 * ataque;
            mensaje = nombre + " rival ha usado atacar";
            energia++;
        }else {
            if (elemento.equalsIgnoreCase("fuego")) {
                referencia = 6 * 95 * ataque;
                mensaje = nombre + " rival ha usado Furia de fuego";
            }

            else if(elemento.equalsIgnoreCase("rayo")){
                referencia = 6 * 100 * ataque;
                mensaje = nombre + " rival ha usado Rayo Fulminante";
            }

            else if(elemento.equalsIgnoreCase("viento")){
                referencia = 6 * 105 * ataque;
                mensaje = nombre + " rival ha usado Flecha huracán";
            }

            else if(elemento.equalsIgnoreCase("agua")){
                referencia = 6 * 110 * ataque;
                mensaje = nombre + " rival Ola de la muerte";
            }

            else if(elemento.equalsIgnoreCase("tierra")){
                referencia = 6 * 115 * ataque;
                mensaje = nombre + " rival ha usado Terremoto Aterrador";
            }
            energia = 0;
        }
        return referencia;
    }
}

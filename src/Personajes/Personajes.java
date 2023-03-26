package Personajes;

import com.nicosteuerberg.datos.PedirDatos;
import com.nicosteuerberg.datos.SacarMensaje;

import javax.swing.*;

public class Personajes {
    public final static int RIVAL=9;
    String nombre;
    String elemento;
    String tipo;
    int vida;
    int ataque;
    int defensa;
    int velocidad;
    float resistenciaAtaque;
    int energia;
    String mensaje;

    /**
     *
     * @param nombre
     * @param elemento = fuego||rayo||viento||agua||tierra
     * @param tipo = ofensivo||defensivo
     * @param vida
     * @param ataque
     * @param defensa
     * @param velocidad
     * @param resistenciaAtaque = sirve para que si se defienden en ese turno reciba menos daño
     * @param energia = para saber si puede usar el movimiento especial
     * @param mensaje = es el mensaje que utilizaremos en las clases batallas para que salga un mensaje del movimiento que hacen
     */
    public Personajes(String nombre, String elemento, String tipo, int vida, int ataque, int defensa, int velocidad, float resistenciaAtaque, int energia, String mensaje) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.tipo = tipo;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.resistenciaAtaque = resistenciaAtaque;
        this.energia = energia;
        this.mensaje = mensaje;
    }
    public Personajes(){};
    String [] opciones = {"Atacar","Defender","Movimiento especial"};
    public Integer movimientos(int opcionQ){
        Integer opcion = null;
        Integer referencia = null; //referencia al movimiento especial, el daño hecho en atacar o en ataque especial, o si se está a defender
        if(opcionQ!=RIVAL) {
            do {
                try {
                    opcion = SacarMensaje.pedirOpciones("Es turno de "+nombre+": "+"\nEscoja el movimiento", opciones);
                } catch (Exception e) {
                    SacarMensaje.sacarVentana("Error al escoger la opcion, intentelo de nuevo");
                    opcion=null;
                }
            }
            while (opcion == null);
        }else{
            if(energia<3){
                opcion=0;
            }else{
                opcion=2;
            }
        }
        /**
         * opcion = 0 -> atacar
         * opcion = 1 -> defender
         * opcion = 2 -> movimiento especial
         * @return referencia, 0 si se defiende, numero si ataca
         */
        resistenciaAtaque = 1;
        switch(opcion){
            case 0:
                if(energia < 3){
                    energia++;
                }
                referencia = 25 * ataque;
                mensaje = nombre + " ha usado atacar";
                break;
            case 1:
                if(energia < 3){
                    energia++;
                }
                mensaje = nombre + " se está defendiendo";
                resistenciaAtaque = 1.25f;
                referencia = 0;
                break;
            case 2:
                if(energia < 3){
                    SacarMensaje.sacarVentana("Energia insuficiente");
                    referencia = movimientos(opcionQ);
                }else {
                    if (elemento.equalsIgnoreCase("fuego")) {
                            referencia = 95 * ataque;
                            mensaje = nombre + " ha usado Furia de fuego";
                    }

                    else if(elemento.equalsIgnoreCase("rayo")){
                            referencia = 100 * ataque;
                            mensaje = nombre + " ha usado Rayo Fulminante";
                    }

                    else if(elemento.equalsIgnoreCase("viento")){
                            referencia = 105 * ataque;
                            mensaje = nombre + " ha usado Flecha huracán";
                    }

                    else if(elemento.equalsIgnoreCase("agua")){
                            referencia = 110 * ataque;
                            mensaje = nombre + " Ola de la muerte";
                    }

                    else if(elemento.equalsIgnoreCase("tierra")){
                            referencia = 115 * ataque;
                            mensaje = nombre + " ha usado Terremoto Aterrador";
                    }
                    energia = 0;
                }
                break;
        }
        return referencia;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public float getResistenciaAtaque() {
        return resistenciaAtaque;
    }

    public void setResistenciaAtaque(int resistenciaAtaque) {
        this.resistenciaAtaque = resistenciaAtaque;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    @Override
    public String toString() {
        if(vida<0){
            return getNombre() +", " + getElemento() +", " + getTipo() + ", " + "0 PS";
        }else {
            return getNombre() + ", " + getElemento() + ", " + getTipo() + ", " + getVida() + " PS, " + getAtaque() + " ATK, " + getDefensa() + " DEF, " + getVelocidad() + " Vel";
        }
    }
}

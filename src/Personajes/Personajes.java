package Personajes;

import com.nicosteuerberg.datos.PedirDatos;

import javax.swing.*;

public class Personajes {
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
    public Integer movimientos(){
        Integer opcion = null;
        Integer referencia = null; //referencia al movimiento especial, el daño hecho en atacar o en ataque especial, o si se está a defender
        do {
            try {
                opcion = JOptionPane.showOptionDialog(null, "Escoja el movimiento", "", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
            } catch (Exception e) {
                System.out.println("Erro ao escoller a opcion");
            }
            System.out.println(opcion);
        }while (opcion==null);
        /**
         * opcion = 0 -> atacar
         * opcion = 1 -> defender
         * opcion = 2 -> movimiento especial
         * @return referencia, null si se defiende,si es evitar el daño(fuego) = 0, subir ataque(elctrico) = -1, desviar el ataque al atacante(viento) = -2, curar(agua) = -3, subir defensa(tierra) = -4
         */
        resistenciaAtaque = 1;
        switch(opcion){
            case 0:
                if(energia < 3){
                    energia++;
                }
                referencia = 6 * 25 * ataque;
                mensaje = nombre + " ha usado atacar";
                break;
            case 1:
                if(energia < 3){
                    energia++;
                }
                mensaje = nombre + " se está defendiendo";
                resistenciaAtaque = 1.2f;
                referencia = null;
                break;
            case 2:
                if(energia < 3){
                    JOptionPane.showMessageDialog(null, "Energia insuficiente");
                    movimientos();
                }

                else {
                    if (elemento.equalsIgnoreCase("fuego")) {
                        if (tipo.equalsIgnoreCase("ofensivo")) {
                            referencia = 6 * 95 * ataque;
                            mensaje = nombre + " ha usado Furia de fuego";
                        } else {
                            referencia = 0;
                            mensaje = nombre + " ha usado Llamas Ardientes";
                        }
                    }

                    else if(elemento.equalsIgnoreCase("rayo")){
                        if (tipo.equalsIgnoreCase("ofensivo")) {
                            referencia = 6 * 100 * ataque;
                            mensaje = nombre + " ha usado Rayo Fulminante";
                        } else {
                            referencia = -1;
                            mensaje = nombre + " ha usado Alto Voltaje";
                        }
                    }

                    else if(elemento.equalsIgnoreCase("viento")){
                        if (tipo.equalsIgnoreCase("ofensivo")) {
                            referencia = 6 * 105 * ataque;
                            mensaje = nombre + " ha usado Flecha huracán";
                        } else {
                            referencia = -2;
                            mensaje = nombre + " ha usado Cortina de Aire";
                        }
                    }

                    else if(elemento.equalsIgnoreCase("agua")){
                        if (tipo.equalsIgnoreCase("ofensivo")) {
                            referencia = 6 * 110 * ataque;
                            mensaje = nombre + " Ola de la muerte";
                        } else {
                            referencia = -3;
                            mensaje = nombre + " ha usado Sanación acuática";
                        }
                    }

                    else if(elemento.equalsIgnoreCase("tierra")){
                        if (tipo.equalsIgnoreCase("ofensivo")) {
                            referencia = 6 * 115 * ataque;
                            mensaje = nombre + " ha usado Terremoto Aterrador";
                        } else {
                            referencia = -4;
                            mensaje = nombre + " ha usado Colinas de Hierro";
                        }
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
        return nombre +", " + elemento +", " + tipo + ", " + vida + " ps, "+ ataque + " ATK, " + defensa + " DEF, " + velocidad + " Vel";
    }
}

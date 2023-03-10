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
    int resistenciaAtaque;
    int energia;
    String mesanje;

    /**
     *
     * @param nombre
     * @param elemento
     * @param tipo
     * @param vida
     * @param ataque
     * @param defensa
     * @param velocidad
     * @param resistenciaAtaque
     * @param energia
     */
    public Personajes(String nombre, String elemento, String tipo, int vida, int ataque, int defensa, int velocidad, int resistenciaAtaque, int energia) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.tipo = tipo;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.resistenciaAtaque = resistenciaAtaque;
        this.energia = energia;
    }
    String [] opciones = {"Atacar","Defender","Movimiento especial"};
    public Integer movimientos(){
        Integer opcion = null;
        Integer referencia; //referencia al movimiento especial, el daño hecho en atacar o en ataque especial, o si se está a defender
        do {
            try {
                opcion = JOptionPane.showOptionDialog(null, "Escoja el movimiento", "", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
            } catch (Exception e) {
                System.out.println("Erro ao escoller a opcion");
            }
            System.out.println(opcion);
        }while (opcion==null);
        /**
         * opcion = 0 -> movimiento especial
         * opcion = 1 -> defender
         * opcion = 2 -> atacar
         * @return
         */
        switch(opcion){
            case 0:
                //JOptionPane.showMessageDialog(null, nombre + " ha usado atacar");
                break;
            case 1:
                //JOptionPane.showMessageDialog(null, nombre + " se está defendiendo");
                break;
            case 2:
                if(elemento.equals("fuego")){
                    if(tipo.equals("Ofensivo")){

                    }else{

                    }
                }
                break;
        }

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

    public int getResistenciaAtaque() {
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
}

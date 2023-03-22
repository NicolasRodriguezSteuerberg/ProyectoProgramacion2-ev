package Personajes;

import Datos.Libreria;
import java.util.ArrayList;

public class Subditos extends Personajes{
    private int nivel;

    /**
     * @param nombre nombre subdito
     * @param elemento elemento subdito
     * @param tipo ofensivo o defensivo
     * @param vida vida máxima/actual
     * @param ataque
     * @param defensa
     * @param velocidad
     * @param resistenciaAtaque
     * @param energia
     */
    public Subditos(String nombre, String elemento, String tipo, int vida, int ataque, int defensa, int velocidad, float resistenciaAtaque, int energia, String mensaje, int nivel) {
        super(nombre, elemento, tipo, vida, ataque, defensa, velocidad, resistenciaAtaque, energia, mensaje);
        this.nivel = nivel;
    }
    public Subditos(){}

    public void subirNivel(ArrayList<Subditos> lista){
        int aVida, aAtaque, aDefensa, aVelocidad;
        for (int i=0; i < lista.size(); i++){
            aVida = lista.get(i).vida;
            aAtaque = lista.get(i).ataque;
            aDefensa = lista.get(i).defensa;
            aVelocidad = lista.get(i).velocidad;
            if (lista.get(i).elemento.equalsIgnoreCase("fuego")) {
                if (lista.get(i).tipo.equalsIgnoreCase("ofensivo")) {
                    aVida =+ 8;aAtaque =+ Libreria.numeroRandom(6,7);aDefensa =+ 2;aVelocidad =+ 3;
                } else {
                    aVida =+ 9; aAtaque =+ Libreria.numeroRandomProbabilidad(4,5, 25); aDefensa =+ Libreria.numeroRandom(3,4); aVelocidad =+ Libreria.numeroRandom(2,3);
                }
            }

            else if(lista.get(i).elemento.equalsIgnoreCase("rayo")){
                if (lista.get(i).tipo.equalsIgnoreCase("ofensivo")) {
                    aVida =+ 9; aAtaque =+ Libreria.numeroRandom(5,6); aDefensa =+ 3; aVelocidad =+ 4;
                } else {
                    aVida =+ 10; aAtaque =+ Libreria.numeroRandomProbabilidad(3,4, 25); aDefensa =+ 4; aVelocidad =+ Libreria.numeroRandom(3,4);
                }
            }

            else if(lista.get(i).elemento.equalsIgnoreCase("viento")){
                if (lista.get(i).tipo.equalsIgnoreCase("ofensivo")) {
                    aVida =+ 10; aAtaque =+ Libreria.numeroRandom(5,6); aDefensa =+ 2; aVelocidad =+ 5;
                } else {
                    aVida =+ 11; aAtaque =+ 3; aDefensa =+ Libreria.numeroRandom(4,5); aVelocidad =+ Libreria.numeroRandom(4,5);
                }
            }

            else if(lista.get(i).elemento.equalsIgnoreCase("agua")){
                if (lista.get(i).tipo.equalsIgnoreCase("ofensivo")) {
                    aVida =+ 11; aAtaque =+ 4; aDefensa =+ Libreria.numeroRandom(3,4); aVelocidad =+ 3;
                } else {
                    aVida =+ 12; aAtaque =+ Libreria.numeroRandomProbabilidad(2,3,25); aDefensa =+ Libreria.numeroRandom(5,6); aVelocidad =+ Libreria.numeroRandom(2,3);
                }
            }

            else if(lista.get(i).elemento.equalsIgnoreCase("tierra")){
                if (lista.get(i).tipo.equalsIgnoreCase("ofensivo")) {
                    aVida =+ 12; aAtaque =+ Libreria.numeroRandom(3,4); aDefensa =+ 3; aVelocidad =+ Libreria.numeroRandomProbabilidad(2,3,25);
                } else {
                    aVida =+ 13; aAtaque =+ 2; aDefensa =+ Libreria.numeroRandom(6,7); aVelocidad =+ 2;
                }
            }
            lista.get(i).setVida(aVida);
            lista.get(i).setAtaque(aAtaque);
            lista.get(i).setDefensa(aDefensa);
            lista.get(i).setVelocidad(aVelocidad);
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}

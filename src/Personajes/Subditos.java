package Personajes;

import Datos.Random;
import java.util.ArrayList;

public class Subditos extends Personajes{
    private int nivel;

    /**
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
    public Subditos(String nombre, String elemento, String tipo, int vida, int ataque, int defensa, int velocidad, int resistenciaAtaque, int energia, String mensaje, int nivel) {
        super(nombre, elemento, tipo, vida, ataque, defensa, velocidad, resistenciaAtaque, energia, mensaje);
        this.nivel = nivel;
    }
    public void subirNivel(ArrayList<Personajes> lista){
        int aVida, aAtaque, aDefensa, aVelocidad;
        for (int i=0; i < lista.size(); i++){
            aVida = lista.get(i).vida;
            aAtaque = lista.get(i).ataque;
            aDefensa = lista.get(i).defensa;
            aVelocidad = lista.get(i).velocidad;
            if (lista.get(i).elemento.equalsIgnoreCase("fuego")) {
                if (lista.get(i).tipo.equalsIgnoreCase("ofensivo")) {
                    aVida =+ 8;aAtaque =+ Random.numeroRandom(6,7);aDefensa =+ 2;aVelocidad =+ 3;
                } else {
                    aVida =+ 9; aAtaque =+ Random.numeroRandomProbabilidad(4,5, 25); aDefensa =+ Random.numeroRandom(3,4); aVelocidad =+ Random.numeroRandom(2,3);
                }
            }

            else if(lista.get(i).elemento.equalsIgnoreCase("rayo")){
                if (lista.get(i).tipo.equalsIgnoreCase("ofensivo")) {
                    aVida =+ 9; aAtaque =+ Random.numeroRandom(5,6); aDefensa =+ 3; aVelocidad =+ 4;
                } else {
                    aVida =+ 10; aAtaque =+ Random.numeroRandomProbabilidad(3,4, 25); aDefensa =+ 4; aVelocidad =+ Random.numeroRandom(3,4);
                }
            }

            else if(lista.get(i).elemento.equalsIgnoreCase("viento")){
                if (lista.get(i).tipo.equalsIgnoreCase("ofensivo")) {
                    aVida =+ 10; aAtaque =+ Random.numeroRandom(5,6); aDefensa =+ 2; aVelocidad =+ 5;
                } else {
                    aVida =+ 11; aAtaque =+ 3; aDefensa =+ Random.numeroRandom(4,5); aVelocidad =+ Random.numeroRandom(4,5);
                }
            }

            else if(lista.get(i).elemento.equalsIgnoreCase("agua")){
                if (lista.get(i).tipo.equalsIgnoreCase("ofensivo")) {
                    aVida =+ 11; aAtaque =+ 4; aDefensa =+ Random.numeroRandom(3,4); aVelocidad =+ 3;
                } else {
                    aVida =+ 12; aAtaque =+ Random.numeroRandomProbabilidad(2,3,25); aDefensa =+ Random.numeroRandom(5,6); aVelocidad =+ Random.numeroRandom(2,3);
                }
            }

            else if(lista.get(i).elemento.equalsIgnoreCase("tierra")){
                if (lista.get(i).tipo.equalsIgnoreCase("ofensivo")) {
                    aVida =+ 12; aAtaque =+ Random.numeroRandom(3,4); aDefensa =+ 3; aVelocidad =+ Random.numeroRandomProbabilidad(2,3,25);
                } else {
                    aVida =+ 13; aAtaque =+ 2; aDefensa =+ Random.numeroRandom(6,7); aVelocidad =+ 2;
                }
            }
            lista.get(i).setVida(aVida);
            lista.get(i).setAtaque(aAtaque);
            lista.get(i).setDefensa(aDefensa);
            lista.get(i).setVelocidad(aVelocidad);
        }
    }

}

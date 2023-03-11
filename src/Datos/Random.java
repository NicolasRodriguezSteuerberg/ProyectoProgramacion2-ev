package Datos;

public class Random {

    public static int numeroRandom(int minimo, int maximo){
        maximo++;
        int num = (int) (Math.random()*(maximo-minimo)+minimo);
        return num;
    }

    public static int numeroRandomProbabilidad(int minimo, int maximo, int porcentaje){
        /**
         * minimo, valor bajo a recibir
         * máximo, valor alto a recibir
         * porcentaje, porcentaje de que sea valor máximo
         */
        int num = (int) (Math.random()*101);//devuelve un valor entre 0 y 100
        if(num <= porcentaje){
            num = maximo;
        } else {
            num = minimo;
        }
        return num;
    }

}

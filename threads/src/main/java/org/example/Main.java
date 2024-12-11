package org.example;

public class Main {
    public static void main(String[] args) {
        /*ThreadClass threadClass = new ThreadClass();
        for (int i = 0; i < 10; i++) {
            Thread thread0 = new Thread(threadClass);
            thread0.start();
        }*/
        for (int i = 0; i < 10; i++) {
            ThreadClassHeranca threadClassHeranca = new ThreadClassHeranca(i);
            threadClassHeranca.start();
        }

        //Precisa herdar de Runnable ou estender de Thread (estender deve ser evitado pois e uma herança preguisoça)
        /*Teste teste = new Teste(1);
        Thread thread = new Thread(teste);*/

        System.out.println("Programa principal:: " + Thread.currentThread().getName());
    }
}

package org.example;

public class ThreadClassHeranca extends Thread{

    private int numero;
    public ThreadClassHeranca(int numero){
        this.numero = numero;
    }

    public void run() {
        System.out.println("Chamando Run - executando a Thread:: " + Thread.currentThread().getName() +
                " numero:: " + this.numero);
    }
}

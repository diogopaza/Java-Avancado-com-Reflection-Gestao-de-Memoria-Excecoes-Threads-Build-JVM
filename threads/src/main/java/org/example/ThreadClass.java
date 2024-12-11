package org.example;

public class ThreadClass implements Runnable{


    @Override
    public void run() {
        System.out.println("Chamando Run - executando a Thread:: " + Thread.currentThread().getName());
    }
}

package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var impressora1 = new Impressora(1);
//        var impressora2 = new Impressora(2);
//        var impressora3 = new Impressora(3);

        Thread threadImpressora1 = new Thread(impressora1);
//        Thread threadImpressora2 = new Thread(impressora2);

        //threadImpressora1.setPriority(10); //10 tem amis prioridade 1 menor prioridade
        System.out.println(threadImpressora1.isAlive());
        threadImpressora1.start();
        threadImpressora1.join();
        System.out.println(threadImpressora1.isAlive());
//        threadImpressora2.start();

    }
}

class Impressora implements Runnable {

    private int id;

    public Impressora(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        /*for (int i = 0; i <= 10; i++) {
            System.out.println("Impressora " + id + " valor: " + i);
        }*/
        System.out.println("Olá, mundo");
    }
}

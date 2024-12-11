package br.com.alura;

public class ExecutaSemThread {

    private static int CONTADOR = 0;

    public void executar(){
        CONTADOR ++;
        System.out.println("Tarefa numero " + CONTADOR + " inicializada");
    }
}

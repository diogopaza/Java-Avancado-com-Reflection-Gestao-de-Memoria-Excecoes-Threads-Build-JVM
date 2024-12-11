package br.com.alura;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TesteMultiplasThreads {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        //Executor que cria Threads virtuais
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        Instant inicio = Instant.now();

        try(ExecutorService e = executorService){
            for(int i =1; i<= 10000; i++){
                var tarefa = new ExecutaTarefa();
                e.execute(tarefa);
            }
        }

        Instant fim = Instant.now();
        Duration duracao = Duration.between(inicio, fim);
        System.out.println("Tempo gasto:: " + duracao.getSeconds());

        /*Instant inicio = Instant.now();

        for(int i =1; i<= 10000; i++){
            var semThread = new ExecutaSemThread();
            semThread.executar();
        }

        Instant fim = Instant.now();
        Duration duracao = Duration.between(inicio, fim);
        System.out.println("Tempo gasto:: " + duracao.getSeconds());*/


    }
}

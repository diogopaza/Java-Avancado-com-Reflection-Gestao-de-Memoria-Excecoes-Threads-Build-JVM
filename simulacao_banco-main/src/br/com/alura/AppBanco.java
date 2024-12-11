package br.com.alura;

import java.math.BigDecimal;

public class AppBanco {
    public static void main(String[] args) {
        var cliente = new Cliente("Joao");
        var conta = new Conta(cliente, new BigDecimal(150));

        var operacao = new OperacaoSaque(conta, new BigDecimal(150));
        //saques de forma sequencial
        //saque joao
       /* operacao.executa();
        //saque maria
        operacao.executa();*/

        //saques de forma paralela --- Threads
        Thread saqueJoao = new Thread(operacao);
        Thread saqueMaria = new Thread(operacao);

        saqueJoao.start();
        saqueMaria.start();

        try {
            saqueJoao.join();
            saqueMaria.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("App Banco: " + Thread.currentThread().getName());
        System.out.println("Saldo final: " + conta.getSaldo());



    }
}

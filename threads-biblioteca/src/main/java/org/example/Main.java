package org.example;

public class Main {
    public static void main(String[] args) {
        var maria = new Pessoa("Maria");
        var joao = new Pessoa("Joao");
        var roberto = new Pessoa("Roberto");

        var picaPauAmarelo = new Livro("Pica pau amarelo");

        var operacao = new Operacao(picaPauAmarelo);

        Thread threadMaria = new Thread(operacao, joao.getNome());
        Thread threadJoao = new Thread(operacao, maria.getNome());
        Thread threadRoberto = new Thread(operacao, roberto.getNome());

        threadMaria.start();
        threadJoao.start();
        threadRoberto.start();

        try {
            threadMaria.join();
            threadJoao.join();
            threadRoberto.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Reservas finalizadas!\n");
    }
}

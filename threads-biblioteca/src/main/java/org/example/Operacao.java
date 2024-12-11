package org.example;

public class Operacao implements Runnable{

    private Pessoa pessoa;
    private Livro livro;

    public Operacao(Livro livro){
        this.livro = livro;
    }

    @Override
    public void run() {
        emprestarLivro(this.livro);
    }

    public synchronized void emprestarLivro(Livro livro){
        System.out.println("Iniciando a reserva.");
        if(livro.isReservado()){
            System.out.println("O livro já foi reservado, " + Thread.currentThread().getName());
        } else{
            livro.setReservado(true);
            System.out.println("Reserva efetuada com sucesso! Aproveite a leitura, " + Thread.currentThread().getName());
        }
    }
}

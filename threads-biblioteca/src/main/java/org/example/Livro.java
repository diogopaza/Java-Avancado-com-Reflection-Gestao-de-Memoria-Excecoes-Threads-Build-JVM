package org.example;

public class Livro {

    private String nomeLivro;

    private boolean reservado = false;

    public Livro(String nomeLivro){
        this.nomeLivro = nomeLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
}

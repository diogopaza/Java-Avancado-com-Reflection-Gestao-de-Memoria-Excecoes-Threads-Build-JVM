package org.generics;

public class Endereco {
     private String cidade;
     private String estado;

     public Endereco(String cidade, String estado){
         this.cidade = cidade;
         this.estado =  estado;
     }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

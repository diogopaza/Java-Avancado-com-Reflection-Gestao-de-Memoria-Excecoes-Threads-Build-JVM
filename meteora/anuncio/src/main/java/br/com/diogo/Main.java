package br.com.diogo;

import br.com.diogo.model.Anuncio;
import br.com.diogo.model.Produto;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        var produto = new Produto("TV", new BigDecimal(2000), "Nova Geração", "Televisao");
        var anuncio = new Anuncio(produto, new BigDecimal(10), 2);
        System.out.println(anuncio.toString());
    }
}

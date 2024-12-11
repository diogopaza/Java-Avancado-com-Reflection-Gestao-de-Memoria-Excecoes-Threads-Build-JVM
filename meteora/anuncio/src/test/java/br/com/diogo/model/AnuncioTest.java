package br.com.diogo.model;

import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AnuncioTest {

    @org.junit.jupiter.api.Test
    void getQuantidade() {
        var produto = new Produto("TV", new BigDecimal(2000), "Nova Geração", "Televisao");
        var anuncio = new Anuncio(produto, new BigDecimal(10), 2);

        Assertions.assertEquals(2, anuncio.getQuantidade());
    }
}

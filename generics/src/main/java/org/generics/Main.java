package org.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Object[] objects = new Object[2];
        System.out.println("INICIANDO SISTEMA");
        Pessoa pessoa = new Pessoa(10L, "Pedro Paulo", "0222525");
        Endereco endereco = new Endereco("Cascavel", "Parana");
        Box box = new Box();
        Box box2 = new Box();
        box.setObject(pessoa);
        box2.setObject(endereco);
        System.out.println(box.getObject().toString());
        System.out.println(box2.getObject().toString());
        System.out.println("INICIANDO GENERICS");
        BoxGenerics<Pessoa> box3 = new BoxGenerics<Pessoa>();
        box3.setObject(pessoa);
        objects[0] = pessoa;
        objects[1] = endereco;
        BoxGenerics.percorrerArray(objects);


    }
}

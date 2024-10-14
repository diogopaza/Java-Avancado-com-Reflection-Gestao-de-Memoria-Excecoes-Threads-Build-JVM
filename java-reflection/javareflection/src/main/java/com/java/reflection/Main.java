package com.java.reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoa = new Pessoa();
        Transformator transformator = new Transformator();
       // transformator.transform(pessoa);
        PessoaDto pessoaDto = new PessoaDto("teste","123");
        System.out.println(pessoaDto.getNome());
    }
}

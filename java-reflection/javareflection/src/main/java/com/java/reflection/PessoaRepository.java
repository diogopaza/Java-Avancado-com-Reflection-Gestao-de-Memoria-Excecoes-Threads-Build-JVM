package com.java.reflection;

import com.java.reflection.Pessoa;

public class PessoaRepository {
    
    public Pessoa list(){
        return new Pessoa(1L,"João","1234");
    } 

}

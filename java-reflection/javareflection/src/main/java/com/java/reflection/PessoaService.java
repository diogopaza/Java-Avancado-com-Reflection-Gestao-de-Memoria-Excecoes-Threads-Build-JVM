package com.java.reflection;

import com.java.reflection.PessoaRepository;

public class PessoaService {
    
    public PessoaDto list() {

        Pessoa pessoa = new PessoaRepository().list();
        PessoaDto pessoaDto = new PessoaDto(pessoa.getNome(), pessoa.getCpf());
        return pessoaDto;
    }

}




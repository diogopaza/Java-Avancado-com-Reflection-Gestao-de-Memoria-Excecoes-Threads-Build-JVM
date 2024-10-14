package com.java.reflection;

public class PessoaDto {

    public PessoaDto(){}

    public PessoaDto(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    String nome;
    String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

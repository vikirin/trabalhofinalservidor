package com.example.trabalhofinal.model;

public class cliente {
    private long idCliente;
    private String nome;
    private String nomeConta;
    private String senha;

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public cliente(long idCliente, String nome, String nomeConta, String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.nomeConta = nomeConta;
        this.senha = senha;
    }

    public cliente() {
    }
}

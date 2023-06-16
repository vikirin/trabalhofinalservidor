package model;

public class cliente {
    private long idCliente;
    private String nome;
    private String nomeconta;
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

    public String getNomeconta() {
        return nomeconta;
    }

    public void setNomeconta(String nomeconta) {
        this.nomeconta = nomeconta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public cliente(long idCliente, String nome, String nomeconta, String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.nomeconta = nomeconta;
        this.senha = senha;
    }

    public cliente() {
    }
}

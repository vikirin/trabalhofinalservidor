package model;

public class funcionario {

    private Long idFuncionario;

    private String nome;

    private String senha;

    private String CPF;

    public Long getIdFuncionario() {return idFuncionario;}

    public void setIdFuncionario(Long idFuncionario) {this.idFuncionario = idFuncionario;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

    public String getCPF() {return CPF;}

    public void setCPF(String CPF) {this.CPF = CPF;}

    public funcionario(Long idFuncionario, String nome, String senha, String CPF) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.senha = senha;
        this.CPF = CPF;
    }

    public funcionario() {
    }
}

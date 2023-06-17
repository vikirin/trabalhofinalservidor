package com.example.trabalhofinal.model;

public class pre_pedidopizzafinal {
    private String tamanho;
    private String sabor;
    private Float valortotalp;
    private Long idPedido;
    private Long idcliente;
    private Long idPizza;

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Float getValortotalp() {
        return valortotalp;
    }

    public void setValortotalp(Float valortotalp) {
        this.valortotalp = valortotalp;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdcliente() {return idcliente;}

    public void setIdcliente(Long idcliente) {this.idcliente = idcliente;}

    public Long getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Long idPizza) {
        this.idPizza = idPizza;
    }

    public pre_pedidopizzafinal(String tamanho, String sabor, Float valortotalp, Long idPedido, Long idcliente, Long idPizza) {
        this.tamanho = tamanho;
        this.sabor = sabor;
        this.valortotalp = valortotalp;
        this.idPedido = idPedido;
        this.idcliente = idcliente;
        this.idPizza = idPizza;
    }

    public pre_pedidopizzafinal() {
    }
}

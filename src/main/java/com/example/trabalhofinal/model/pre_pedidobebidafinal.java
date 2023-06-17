package com.example.trabalhofinal.model;

public class pre_pedidobebidafinal {
    private String nomebebida;
    private Float valortotalb;
    private Long quantidade;
    private Long idclinte;
    private Long idbebida;

    private Long idpedido;

    public String getNomebebida() {
        return nomebebida;
    }

    public void setNomebebida(String nomebebida) {
        this.nomebebida = nomebebida;
    }

    public Float getValortotalb() {
        return valortotalb;
    }

    public void setValortotalb(Float valortotalb) {
        this.valortotalb = valortotalb;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdclinte() {
        return idclinte;
    }

    public void setIdclinte(Long idclinte) {
        this.idclinte = idclinte;
    }

    public Long getIdbebida() {
        return idbebida;
    }

    public void setIdbebida(Long idbebida) {
        this.idbebida = idbebida;
    }

    public Long getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Long idpedido) {
        this.idpedido = idpedido;
    }

    public pre_pedidobebidafinal(String nomebebida, Float valortotalb, Long quantidade, Long idclinte, Long idbebida, Long idpedido) {
        this.nomebebida = nomebebida;
        this.valortotalb = valortotalb;
        this.quantidade = quantidade;
        this.idclinte = idclinte;
        this.idbebida = idbebida;
        this.idpedido = idpedido;
    }

    public pre_pedidobebidafinal() {
    }
}

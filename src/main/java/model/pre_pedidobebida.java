package model;

public class pre_pedidobebida {
    private String nomebebida;
    private Float valortotal;
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

    public Float getValortotal() {
        return valortotal;
    }

    public void setValortotal(Float valortotal) {
        this.valortotal = valortotal;
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

    public pre_pedidobebida(String nomebebida, Float valortotal, Long quantidade, Long idclinte, Long idbebida, Long idpedido) {
        this.nomebebida = nomebebida;
        this.valortotal = valortotal;
        this.quantidade = quantidade;
        this.idclinte = idclinte;
        this.idbebida = idbebida;
        this.idpedido = idpedido;
    }

    public pre_pedidobebida() {
    }
}

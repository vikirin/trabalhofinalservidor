package model;

public class bebida {
    private String nomeProduto;
    private Float valor;
    private Long idBebida;
    private String imagem;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Long getIdBebida() {return idBebida;}

    public void setIdBebida(Long idBebida) {this.idBebida = idBebida;}

    public String getImagem() {return imagem;}

    public void setImagem(String imagem) {this.imagem = imagem;}

    public bebida(String nomeProduto, Float valor, Long idBebida,String imagem) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.idBebida = idBebida;
        this.imagem = imagem;
    }

    public bebida() {
    }
}

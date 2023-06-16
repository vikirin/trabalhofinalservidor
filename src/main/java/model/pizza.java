package model;

public class pizza {
    private String nomeProduto;
    private Float valor;
    private Long idPizza;

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

    public Long getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Long idPizza) {
        this.idPizza = idPizza;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public pizza(String nomeProduto, Float valor, Long idPizza, String imagem) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.idPizza = idPizza;
        this.imagem = imagem;
    }

    public pizza() {
    }
}

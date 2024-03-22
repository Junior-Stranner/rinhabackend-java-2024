package br.com.jujubaprojects.rinhabackendjava.dto;


public class TransacaoRequestDto {

    private String valor;
    private Character tipo;
    private String descricao;

    public TransacaoRequestDto() {
       
    }

    public TransacaoRequestDto(String valor, Character tipo, String descricao) {
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
   
}

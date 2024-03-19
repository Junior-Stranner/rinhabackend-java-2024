package br.com.jujubaprojects.rinhabackendjava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDateTime;



@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transacao_sequence")
   @SequenceGenerator(name = "transacao_sequence" , sequenceName = "transacao_sequence" , allocationSize = 1)
    private Integer id;

    private String tipo;

    private Integer valor;

    private String descricao;

    private LocalDateTime realizadaEm;

    private Integer clienteId;

    public Transacao(String tipo, Integer valor, String descricao, LocalDateTime realizadaEm, Integer clienteId) {
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.realizadaEm = realizadaEm;
        this.clienteId = clienteId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getRealizadaEm() {
        return realizadaEm;
    }

    public void setRealizadaEm(LocalDateTime realizadaEm) {
        this.realizadaEm = realizadaEm;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }


  
}

package br.com.jujubaprojects.rinhabackendjava.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "transacoes")
public class Transacao {

    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transacao_sequence")
   @SequenceGenerator(name = "transacao_sequence" , sequenceName = "transacao_sequence" , allocationSize = 1)
    private int id;
    private int valor;
    private char tipo;

    private String descricao;
    @JsonProperty("realizada_em")
    @DateTimeFormat(pattern = "dd/MM/yyyy - HH:mm")
    @JsonFormat(pattern = "dd/MM/yyyy - HH:mm")
    private LocalDateTime realizadaEm = LocalDateTime.now();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;



    public Transacao(int valor, char tipo, String descricao, LocalDateTime realizadaEm, Cliente cliente) {
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.realizadaEm = realizadaEm;
        this.cliente = cliente;
    }

    public Transacao() {
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

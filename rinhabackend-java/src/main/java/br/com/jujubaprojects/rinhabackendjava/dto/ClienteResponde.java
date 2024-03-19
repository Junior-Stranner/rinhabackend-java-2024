package br.com.jujubaprojects.rinhabackendjava.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.jujubaprojects.rinhabackendjava.model.Extrato;
import br.com.jujubaprojects.rinhabackendjava.model.Transacao;


public class ClienteResponde {
    
    @JsonIgnore
    private int limite;
    private int saldo;

    private List<Transacao> transacoes;

    private Extrato extrato;

    

    public ClienteResponde(int limite, int saldo, List<Transacao> transacoes, Extrato extrato) {
        this.limite = limite;
        this.saldo = saldo;
        this.transacoes = transacoes;
        this.extrato = extrato;
    }

    public ClienteResponde() {
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public Extrato getExtrato() {
        return extrato;
    }

    public void setExtrato(Extrato extrato) {
        this.extrato = extrato;
    }

    
}

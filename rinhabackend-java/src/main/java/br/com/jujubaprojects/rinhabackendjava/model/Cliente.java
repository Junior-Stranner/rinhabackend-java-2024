package br.com.jujubaprojects.rinhabackendjava.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sequence")
    @SequenceGenerator(name = "cliente_sequence" , sequenceName = "cliente_sequence", allocationSize = 1)
    private int id;
    private int limite;
    private int saldo;

    @OneToMany(mappedBy = "cliente")
    private List<Transacao> transacoes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "extrato_id")
    private Extrato extrato;

    
    public Cliente(int limite, int saldo, List<Transacao> transacoes, Extrato extrato) {
        this.limite = limite;
        this.saldo = saldo;
        this.transacoes = transacoes;
        this.extrato = extrato;
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

    public void addTransacao(Transacao transacao) {
        this.transacoes.add(transacao);
        atualizarExtrato();
    }

    private void atualizarExtrato() {
        int saldo = 0;
        for (Transacao transacao : transacoes) {
            saldo += transacao.getValor();
        }
        setSaldo(saldo);
    }

}


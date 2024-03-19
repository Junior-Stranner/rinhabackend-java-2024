package br.com.jujubaprojects.rinhabackendjava.model;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
  /*   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sequence")
    @SequenceGenerator(name = "cliente_sequence" , sequenceName = "cliente_sequence", allocationSize = 1)*/
    private int clienteId;
    private int limite;
    private int saldo;

    

    
    public Cliente() {
    }
    public Cliente(int clienteId ,int limite, int saldo) {
        this.clienteId = clienteId;
        this.limite = limite;
        this.saldo = saldo;
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

}


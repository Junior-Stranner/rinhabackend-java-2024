package br.com.jujubaprojects.rinhabackendjava.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
  /*   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sequence")
    @SequenceGenerator(name = "cliente_sequence" , sequenceName = "cliente_sequence", allocationSize = 1)*/
    private int clienteId;
    private double limite;
    private double saldo;

 

    
    public Cliente() {
    }
    public Cliente(int clienteId ,double limite, double saldo) {
        this.clienteId = clienteId;
        this.limite = limite;
        this.saldo = saldo;
    }

    
    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        this.limite = limite;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double novoSaldo) {
        this.saldo = novoSaldo;
    }
    public int getClienteId() {
        return clienteId;
    }
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    } 
}


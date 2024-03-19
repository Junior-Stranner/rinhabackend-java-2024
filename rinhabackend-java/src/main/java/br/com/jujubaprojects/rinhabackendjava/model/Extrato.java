package br.com.jujubaprojects.rinhabackendjava.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "extratos")
public class Extrato {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "extrato_seuqence")
    @SequenceGenerator(name= "extrato_seuqence", sequenceName = "extrato_seuqence", allocationSize = 1)
    private int id;
    
    @JsonProperty("realizada_em")
    @DateTimeFormat(pattern = "dd/MM/yyyy - HH:mm")
    @JsonFormat(pattern = "dd/MM/yyyy - HH:mm")
    private LocalDateTime dataExtrato = LocalDateTime.now();

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public LocalDateTime getDataExtrato() {
        return dataExtrato;
    }

    public void setDataExtrato(LocalDateTime dataExtrato) {
        this.dataExtrato = dataExtrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}

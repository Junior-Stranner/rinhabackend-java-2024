package br.com.jujubaprojects.rinhabackendjava.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Extrato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "extrato_sequence")
    @SequenceGenerator(name= "extrato_sequence", sequenceName = "extrato_sequence", allocationSize = 1)
    private int id;
    
    @Column(name = "data_hora", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHora = LocalDateTime.now();


    public Extrato() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }


}

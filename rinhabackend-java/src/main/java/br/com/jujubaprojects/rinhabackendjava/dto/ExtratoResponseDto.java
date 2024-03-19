package br.com.jujubaprojects.rinhabackendjava.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ExtratoResponseDto {

    private int id;

    private Saldo saldo;


    public static class Saldo {

        private int total;

        @JsonProperty("data_extrato")
        private LocalDateTime data;

        private int limite;

       
    }
}
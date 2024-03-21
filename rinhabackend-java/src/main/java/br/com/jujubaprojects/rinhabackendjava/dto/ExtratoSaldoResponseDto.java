package br.com.jujubaprojects.rinhabackendjava.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtratoSaldoResponseDto {
     Integer total;
     @JsonProperty("data_extrato") 
     LocalDateTime dataExtrato;
     Integer limite;
}

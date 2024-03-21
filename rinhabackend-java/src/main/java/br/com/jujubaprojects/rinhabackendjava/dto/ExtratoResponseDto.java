package br.com.jujubaprojects.rinhabackendjava.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ExtratoResponseDto {

     ExtratoSaldoResponseDto saldo;
    @JsonProperty("ultimas_transacoes")
     List<TransacaoExtratoResponseDtO> extratoUltimasTransacoes;


    public ExtratoResponseDto(Integer saldoTotal, LocalDateTime now, double limite) {
    }


    public ExtratoResponseDto(ExtratoResponseDto saldoDTO, List<TransacaoExtratoResponseDtO> ultimasTransacoes) {
        //TODO Auto-generated constructor stub
    }

     
}
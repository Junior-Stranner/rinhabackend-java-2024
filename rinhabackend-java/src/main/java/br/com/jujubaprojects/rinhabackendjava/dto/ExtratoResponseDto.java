package br.com.jujubaprojects.rinhabackendjava.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.jujubaprojects.rinhabackendjava.model.Transacao;


public class ExtratoResponseDto {

     ExtratoSaldoResponseDto saldo;
    @JsonProperty("ultimas_transacoes")
     List<TransacaoExtratoResponseDtO> extratoUltimasTransacoes;


    public ExtratoResponseDto(Integer saldoTotal, LocalDateTime now, double limite) {}


    public ExtratoResponseDto(ExtratoResponseDto saldoDTO, List<Transacao> ultimasTransacoes) {  }

     
}
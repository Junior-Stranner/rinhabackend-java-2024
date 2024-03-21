package br.com.jujubaprojects.rinhabackendjava.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransacaoExtratoResponseDtO {

    Integer valor;
    char tipo;
    String descricao;
    @JsonProperty("realizada_em")
    LocalDateTime realizadaEm;
    
}

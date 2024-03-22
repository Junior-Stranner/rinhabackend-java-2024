package br.com.jujubaprojects.rinhabackendjava.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class TransacaoResponse {

    @JsonProperty("limite_conta")
    private int limite;

    @JsonProperty("saldo_conta")
    private double saldo;

    public TransacaoResponse() {
    }

    public TransacaoResponse(int limite, double saldo) {
        this.limite = limite;
        this.saldo = saldo;
    }
}
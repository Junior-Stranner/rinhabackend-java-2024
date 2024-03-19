package br.com.jujubaprojects.rinhabackendjava.dto;

import java.util.List;



public class ClienteRequestDto {
    
    private int limite;
    private int saldo;

    private List<TransacaoRequestDto> transacoes;

    private ExtratoRequestDto extrato;
    

}

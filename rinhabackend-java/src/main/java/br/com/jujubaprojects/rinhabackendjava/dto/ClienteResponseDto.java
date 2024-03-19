package br.com.jujubaprojects.rinhabackendjava.dto;

import java.util.List;




public class ClienteResponseDto {
    private int id;
    private int limite;
    private int saldo;

    private List<TransacaoRequestDto> transacoes;

    private ExtratoResponseDto extrato;
    
}

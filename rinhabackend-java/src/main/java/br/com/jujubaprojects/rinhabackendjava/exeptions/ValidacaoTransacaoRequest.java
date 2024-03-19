package br.com.jujubaprojects.rinhabackendjava.exeptions;

import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoRequestDto;

public interface ValidacaoTransacaoRequest {
    
    void validar(TransacaoRequestDto transacaoRequest);
}

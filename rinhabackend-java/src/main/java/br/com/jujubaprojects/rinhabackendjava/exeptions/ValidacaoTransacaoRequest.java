package br.com.jujubaprojects.rinhabackendjava.exeptions;

import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoRequest;

public interface ValidacaoTransacaoRequest {
    
    void validar(TransacaoRequest transacaoRequest);
}

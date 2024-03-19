package br.com.jujubaprojects.rinhabackendjava.exeptions.impl;

import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoRequest;
import br.com.jujubaprojects.rinhabackendjava.exeptions.ValidacaoRequestException;
import br.com.jujubaprojects.rinhabackendjava.enums.UnprocessableEntity.UNPROCESSABLE_ENTITY;

public class TipoValidoException implements ValidacaoRequestException{

 
    public void validar(TransacaoRequest transacaoRequest){

        char debito = 'D';
        char credito = 'C';

        try {
            if(transacaoRequest.getTipo() == null || transacaoRequest.getTipo() != credito
             && transacaoRequest.getTipo() != debito){
            throw new ValidacaoRequestException(UNPROCESSABLE_ENTITY.getCodigo(), "Campo 'Tipo' nulo ou com valor diferente do permitido.");

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}

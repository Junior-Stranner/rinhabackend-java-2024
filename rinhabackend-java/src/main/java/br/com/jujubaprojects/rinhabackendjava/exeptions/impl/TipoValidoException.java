package br.com.jujubaprojects.rinhabackendjava.exeptions.impl;

import br.com.jujubaprojects.rinhabackendjava.Web.exception.ValidacaoRequestException;
import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoRequestDto;
import br.com.jujubaprojects.rinhabackendjava.enums.UnprocessableEntity;

public class TipoValidoException extends RuntimeException { 
     
      public void validar(TransacaoRequestDto transacaoRequest){
         char debito = 'D';
        char credito = 'C';

       
            if(transacaoRequest.getTipo() == null || transacaoRequest.getTipo() != credito
             && transacaoRequest.getTipo() != debito){
            throw new ValidacaoRequestException(UnprocessableEntity.UNPROCESSABLE_ENTITY.getCodigo(), "Campo 'Tipo' nulo ou com valor diferente do permitido.");
       }
    }
}

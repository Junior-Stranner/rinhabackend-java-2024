package br.com.jujubaprojects.rinhabackendjava.Web.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.jujubaprojects.rinhabackendjava.exeptions.TipoValidoException;

@ControllerAdvice
public class ApiExceptionHandler  {

       @ExceptionHandler(TipoValidoException.class)
       public ResponseEntity<String> handleipoValidoException(TipoValidoException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
         }
	
}

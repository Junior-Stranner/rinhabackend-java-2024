package br.com.jujubaprojects.rinhabackendjava.Web.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jujubaprojects.rinhabackendjava.Service.TransacaoCrebito;
import br.com.jujubaprojects.rinhabackendjava.Util.MediaType;
import br.com.jujubaprojects.rinhabackendjava.dto.ExtratoResponseDto;
import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoRequestDto;
import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoResponse;
import br.com.jujubaprojects.rinhabackendjava.dto.mapper.TransacaoMapper;
import br.com.jujubaprojects.rinhabackendjava.model.Transacao;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class TransacaoCrebitoController {

     @Autowired
    private TransacaoCrebito transacaoCrebito;

    @PostMapping(value ="/{id}/transacoes",consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML  },
		produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML  })
    public ResponseEntity<TransacaoResponse> efetuarTransacao(@PathVariable Integer id, @RequestBody @Valid TransacaoRequestDto dto) {
        Transacao response = transacaoCrebito.efetuarTransacao(id, TransacaoMapper.toTransacao(dto));
    
        TransacaoResponse responseDto = TransacaoMapper.ToDto(response);
    
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity<ExtratoResponseDto> obterExtrato(@PathVariable Integer id) {  
    ExtratoResponseDto dto = transacaoCrebito.extrato(id);

     if (dto == null) {
      return ResponseEntity.notFound().build();
   }else{
    return ResponseEntity.ok(dto); // Assuming constructor in ExtratoResponseDto
    }
  } 
}

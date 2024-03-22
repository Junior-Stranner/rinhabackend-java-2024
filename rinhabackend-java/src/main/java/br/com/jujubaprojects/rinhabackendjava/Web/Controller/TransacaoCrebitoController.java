package br.com.jujubaprojects.rinhabackendjava.Web.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jujubaprojects.rinhabackendjava.Service.TransacaoCrebito;
import br.com.jujubaprojects.rinhabackendjava.Util.MediaType;
import br.com.jujubaprojects.rinhabackendjava.Web.exception.ErrorMessage;
import br.com.jujubaprojects.rinhabackendjava.dto.ExtratoResponseDto;
import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoRequestDto;
import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoResponse;
import br.com.jujubaprojects.rinhabackendjava.dto.mapper.TransacaoMapper;
import br.com.jujubaprojects.rinhabackendjava.model.Transacao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class TransacaoCrebitoController {

     @Autowired
    private TransacaoCrebito transacaoCrebito;

     @Operation(summary = "Criar um nova Transação", description = "Recurso para criar um nova Transação",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Recurso criado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TransacaoRequestDto.class))),
                    @ApiResponse(responseCode = "422 ", description = "Tipos de dados para cartões inválidos",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
            })
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

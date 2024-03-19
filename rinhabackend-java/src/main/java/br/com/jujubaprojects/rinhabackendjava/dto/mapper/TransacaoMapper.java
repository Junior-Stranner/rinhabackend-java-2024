package br.com.jujubaprojects.rinhabackendjava.dto.mapper;

import org.modelmapper.ModelMapper;

import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoRequestDto;
import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoResponse;
import br.com.jujubaprojects.rinhabackendjava.model.Transacao;

public class TransacaoMapper {
    
     
    public static Transacao toTransacao(TransacaoRequestDto dto){
        return new ModelMapper().map(dto,Transacao.class);
    }
    public static TransacaoResponse ToDto(Transacao entity){
        return new ModelMapper().map(entity,TransacaoResponse.class);
    }
}

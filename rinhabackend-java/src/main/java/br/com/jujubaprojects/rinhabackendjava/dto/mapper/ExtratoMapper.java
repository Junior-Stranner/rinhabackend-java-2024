package br.com.jujubaprojects.rinhabackendjava.dto.mapper;

import org.modelmapper.ModelMapper;

import br.com.jujubaprojects.rinhabackendjava.dto.ExtratoRequestDto;
import br.com.jujubaprojects.rinhabackendjava.dto.ExtratoResponseDto;
import br.com.jujubaprojects.rinhabackendjava.model.Extrato;

public class ExtratoMapper {
    
    public static Extrato toExtrato(ExtratoRequestDto dto){
        return new ModelMapper().map(dto,Extrato.class);
    }
    public static ExtratoResponseDto ToDto(Extrato entity){
        return new ModelMapper().map(entity,ExtratoResponseDto.class);
    }
}

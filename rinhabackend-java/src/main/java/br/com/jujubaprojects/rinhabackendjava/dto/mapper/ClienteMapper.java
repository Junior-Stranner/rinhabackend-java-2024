package br.com.jujubaprojects.rinhabackendjava.dto.mapper;

import org.modelmapper.ModelMapper;

import br.com.jujubaprojects.rinhabackendjava.dto.ClienteRequest;
import br.com.jujubaprojects.rinhabackendjava.dto.ClienteResponse;
import br.com.jujubaprojects.rinhabackendjava.model.Cliente;

public class ClienteMapper {
    
      public static Cliente toCliente(ClienteRequest dto){
        return new ModelMapper().map(dto,Cliente.class);
    }
    public static ClienteResponse ToDto(Cliente entity){
        return new ModelMapper().map(entity,ClienteResponse.class);
    }
}

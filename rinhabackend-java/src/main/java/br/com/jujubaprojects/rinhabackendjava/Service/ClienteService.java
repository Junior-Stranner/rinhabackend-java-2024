package br.com.jujubaprojects.rinhabackendjava.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jujubaprojects.rinhabackendjava.Repository.ClienteRepository;
import br.com.jujubaprojects.rinhabackendjava.model.Cliente;
import jakarta.annotation.PostConstruct;

@Service
public class ClienteService {
        
        @Autowired
        private ClienteRepository clienteRepository;
    
        @PostConstruct
        public List<Cliente> cadastrar() {
        List<Cliente> clientesSalvos = new ArrayList<>();

        clientesSalvos.add(clienteRepository.save(new Cliente(1, 100000, 0)));
        clientesSalvos.add(clienteRepository.save(new Cliente(2, 80000, 0)));
        clientesSalvos.add(clienteRepository.save(new Cliente(3, 1000000, 0)));
        clientesSalvos.add(clienteRepository.save(new Cliente(4, 10000000, 0)));
        clientesSalvos.add(clienteRepository.save(new Cliente(5, 500000, 0)));
        
        return clientesSalvos;
    }

       public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
       }
}

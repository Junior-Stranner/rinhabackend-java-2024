package br.com.jujubaprojects.rinhabackendjava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jujubaprojects.rinhabackendjava.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}

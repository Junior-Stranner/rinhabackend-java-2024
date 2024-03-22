package br.com.jujubaprojects.rinhabackendjava.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jujubaprojects.rinhabackendjava.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
    @Query("SELECT c FROM Cliente c WHERE c.id = :id")
    Optional<Cliente> buscarClientePorId(Integer id);
    
}

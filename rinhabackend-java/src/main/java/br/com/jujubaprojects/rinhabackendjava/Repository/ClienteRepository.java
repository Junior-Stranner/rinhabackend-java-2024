package br.com.jujubaprojects.rinhabackendjava.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jujubaprojects.rinhabackendjava.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
    @Query("select * from cliente where id = :id")
    Optional<Cliente> buscarClientePorId(@Param("id") Integer id);
}

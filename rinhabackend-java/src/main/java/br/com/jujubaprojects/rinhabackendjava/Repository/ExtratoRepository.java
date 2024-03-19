package br.com.jujubaprojects.rinhabackendjava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jujubaprojects.rinhabackendjava.model.Extrato;

public interface ExtratoRepository extends JpaRepository<Extrato, Integer>{
    
}

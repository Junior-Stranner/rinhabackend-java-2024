package br.com.jujubaprojects.rinhabackendjava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jujubaprojects.rinhabackendjava.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{
    
}

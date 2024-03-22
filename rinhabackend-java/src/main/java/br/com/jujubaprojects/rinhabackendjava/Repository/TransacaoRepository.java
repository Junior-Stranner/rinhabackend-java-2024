package br.com.jujubaprojects.rinhabackendjava.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jujubaprojects.rinhabackendjava.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{
    
    @Query("SELECT SUM(t.valor) FROM Transacao t WHERE t.cliente.id = :id")
    Integer getSaldoTotalById(Integer id);

    @Query("SELECT t FROM Transacao t WHERE t.cliente.id = :id ORDER BY t.realizadaEm DESC")
    List<Transacao> findByIdOrderByRealizadaEmDesc(Integer id);
    
}

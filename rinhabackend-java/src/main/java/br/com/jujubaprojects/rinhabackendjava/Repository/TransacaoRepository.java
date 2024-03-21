package br.com.jujubaprojects.rinhabackendjava.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoExtratoResponseDtO;
import br.com.jujubaprojects.rinhabackendjava.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{
    
    @Query("SELECT SUM(valor) FROM transacao WHERE cliente_id = :id")
    List<Integer> getSaldoTotalById(Integer id);

    @Query("SELECT * FROM transacao WHERE cliente_id = :id ORDER BY realizada_em DESC LIMIT 10")
    List<TransacaoExtratoResponseDtO> findTop10ByIdOrderByRealizadaEmDesc(Integer id);
}

package br.com.jujubaprojects.rinhabackendjava.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.jujubaprojects.rinhabackendjava.Repository.ClienteRepository;
import br.com.jujubaprojects.rinhabackendjava.Repository.TransacaoRepository;
import br.com.jujubaprojects.rinhabackendjava.dto.ExtratoResponseDto;
import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoExtratoResponseDtO;
import br.com.jujubaprojects.rinhabackendjava.model.Cliente;
import br.com.jujubaprojects.rinhabackendjava.model.Transacao;
import jakarta.transaction.Transactional;

@Service
public class TransacaoCrebito {
    
     @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Transactional
    public Transacao efetuarTransacao(Integer id, Transacao transacao) {
        Cliente cliente = clienteRepository.buscarClientePorId(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com o ID: " + id));
        
        calcularSaldo(cliente, transacao);
        Transacao novaTransacao = criarNovaTransacao(cliente, transacao.getTipo(), transacao);
        
        return transacaoRepository.save(novaTransacao);
    }

    public ExtratoResponseDto extrato(Integer id) {
    Cliente cliente = clienteRepository.buscarClientePorId(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com o ID: " + id));

    Integer saldoTotal = transacaoRepository.getSaldoTotalById(id).get(0);
    List<TransacaoExtratoResponseDtO> ultimasTransacoes = transacaoRepository.findByIdOrderByRealizadaEmDesc(id);

    ExtratoResponseDto saldoDTO = new ExtratoResponseDto(saldoTotal, LocalDateTime.now(), cliente.getLimite());
    
    return new ExtratoResponseDto(saldoDTO, ultimasTransacoes);
}


    private Transacao criarNovaTransacao(Cliente cliente, String string, Transacao transacao) {
        return new Transacao(transacao.getTipo(), transacao.getValor(), transacao.getDescricao(), LocalDateTime.now(), cliente.getClienteId());
    }

    private void calcularSaldo(Cliente cliente, Transacao entity) {
        if (entity.getTipo().equals("c")) {
            cliente.setSaldo(cliente.getSaldo() + entity.getValor());
        } else if (entity.getTipo().equals("d")) {
            if (cliente.getSaldo() - entity.getValor() < -cliente.getLimite()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo insuficiente para a transação.");
            } else {
                cliente.setSaldo(cliente.getSaldo() - entity.getValor());
            }
        }
    }
}


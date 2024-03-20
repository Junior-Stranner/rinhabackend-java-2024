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
import br.com.jujubaprojects.rinhabackendjava.dto.TransacaoRequestDto;
import br.com.jujubaprojects.rinhabackendjava.model.Cliente;
import br.com.jujubaprojects.rinhabackendjava.model.Transacao;

@Service
public class TransacaoCrebito {
    
     @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Optional<Object> efetuarTransacao(Integer id, Transacao transacao) {
        return clienteRepository.buscarClientePorId(id)
        .flatMap(cliente -> {
            calcularSaldo(cliente, transacao);
            Transacao novaTransacao = criarNovaTransacao(cliente, transacao.getTipo(), transacao);
            return transacaoRepository.save(novaTransacao)
                
                });
    }


    private Transacao criarNovaTransacao(Cliente cliente, Transacao entity) {
        return new Transacao(entity.getTipo(), entity.getValor(), entity.getDescricao(), LocalDateTime.now(), cliente.getClienteId());
    }

    private void atualizarSaldo(Cliente cliente, Transacao entity) {
        double novoSaldo = cliente.getSaldo();
        if (entity.getTipo().equals("c")) {
            novoSaldo += entity.getValor();
        } else if (entity.getTipo().equals("d")) {
            double novoSaldoAposDebito = novoSaldo - entity.getValor();
            if (novoSaldoAposDebito < -cliente.getLimite()) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
            }
            novoSaldo = novoSaldoAposDebito;
        }
        cliente.setSaldo(novoSaldo);
    }
    
}


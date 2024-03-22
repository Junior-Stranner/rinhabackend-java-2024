package br.com.jujubaprojects.rinhabackendjava.Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jujubaprojects.rinhabackendjava.Service.ClienteService;
import br.com.jujubaprojects.rinhabackendjava.model.Cliente;

@RestController
@RequestMapping("/cadastrar")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

   /*  @PostMapping("/cliente")
    public List<Cliente> cadastro(@RequestBody @Valid  List<Cliente> clientes){
        return clienteService.cadastrar(clientes);

    }*/
  
    @GetMapping()
    public List <Cliente> listarTodos(){
        return clienteService.listarClientes();

    }
}

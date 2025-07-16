package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.ClienteDTO;
import br.com.multicinema.cinemaapi.model.entity.Cliente;
import br.com.multicinema.cinemaapi.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping()
    public ResponseEntity get(){
        List<Cliente> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes.stream().map(ClienteDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ClienteDTO.create(cliente.orElse(null)));
    }
}

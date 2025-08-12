package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.ClienteDTO;
import br.com.multicinema.cinemaapi.model.entity.Cliente;
import br.com.multicinema.cinemaapi.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.InputMismatchException;
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

    @PostMapping()
    public ResponseEntity post(@RequestBody ClienteDTO clienteDTO){
        try{
            Cliente cliente = converter(clienteDTO);
            cliente = clienteService.salvar(cliente);
            return new ResponseEntity(cliente, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o cliente: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody ClienteDTO clienteDTO) {
        if (!clienteService.getClienteById(id).isPresent()) {
            return new ResponseEntity("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            Cliente cliente = converter(clienteDTO);
            cliente.setId(id);
            clienteService.salvar(cliente);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar o cliente: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if (!cliente.isPresent()) {
            return new ResponseEntity("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            clienteService.excluir(cliente.get());
            return new ResponseEntity("Cliente excluído com sucesso", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir o cliente: " + e.getMessage());
        }
    }

    private Cliente converter(ClienteDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        return cliente;
    }

    private boolean validaCelular(String celular) {
        // Verifica se o número segue o padrão dd9xxxxxxxx
        return celular != null && celular.matches("\\d{2}9\\d{8}");
    }
}

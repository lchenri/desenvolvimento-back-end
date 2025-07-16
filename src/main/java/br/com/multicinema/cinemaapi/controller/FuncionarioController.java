package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.FuncionarioDTO;
import br.com.multicinema.cinemaapi.model.entity.Funcionario;
import br.com.multicinema.cinemaapi.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping()
    public ResponseEntity getFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.getFuncionarios();
        return ResponseEntity.ok(funcionarios.stream().map(FuncionarioDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var funcionario = funcionarioService.getFuncionarioById(id);
        if (funcionario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcionario.map(FuncionarioDTO::create));
    }
}

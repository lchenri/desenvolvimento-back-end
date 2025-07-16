package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.UnidadeDTO;
import br.com.multicinema.cinemaapi.service.UnidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/unidades")
public class UnidadeController {

    private final UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @GetMapping()
    public ResponseEntity get() {
        var unidades = unidadeService.getUnidades();
        return ResponseEntity.ok(unidades.stream().map(UnidadeDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var unidade = unidadeService.getUnidadeById(id);
        if (unidade.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(unidade.map(UnidadeDTO::create));
    }
}

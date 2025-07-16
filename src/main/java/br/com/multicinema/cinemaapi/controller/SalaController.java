package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.SalaDTO;
import br.com.multicinema.cinemaapi.service.SalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping()
    public ResponseEntity get(){
        var salas = salaService.getSalas();
        return ResponseEntity.ok(salas.stream().map(SalaDTO::create).collect(java.util.stream.Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var sala = salaService.getSalaById(id);
        if (sala.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sala.map(SalaDTO::create));
    }
}

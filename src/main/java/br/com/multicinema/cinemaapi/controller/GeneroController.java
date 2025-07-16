package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.GeneroDTO;
import br.com.multicinema.cinemaapi.service.GeneroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/generos")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping()
    public ResponseEntity get(){
        var generos = generoService.getGeneros();
        return ResponseEntity.ok(generos.stream().map(GeneroDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var genero = generoService.getGeneroById(id);
        if (genero.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(genero.map(GeneroDTO::create));
    }
}

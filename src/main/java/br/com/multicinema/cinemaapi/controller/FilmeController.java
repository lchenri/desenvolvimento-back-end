package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.FilmeDTO;
import br.com.multicinema.cinemaapi.service.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping()
    public ResponseEntity get(){
        var filmes = filmeService.getFilmes();
        return ResponseEntity.ok(filmes.stream().map(FilmeDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var filme = filmeService.getFilmeById(id);
        if (filme.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filme.map(FilmeDTO::create));
    }
}

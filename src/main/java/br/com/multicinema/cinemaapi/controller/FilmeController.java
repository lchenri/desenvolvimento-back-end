package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.FilmeDTO;
import br.com.multicinema.cinemaapi.model.entity.Filme;
import br.com.multicinema.cinemaapi.service.FilmeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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

    @PostMapping()
    public ResponseEntity post(@RequestBody FilmeDTO filmeDTO){
        try{
            Filme filme = converter(filmeDTO);
            filme = filmeService.salvar(filme);
            return new ResponseEntity(filme, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o filme: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody FilmeDTO filmeDTO) {
        if (!filmeService.getFilmeById(id).isPresent()) {
            return new ResponseEntity("Filme não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            Filme filme = converter(filmeDTO);
            filme.setId(id);
            filmeService.salvar(filme);
            return ResponseEntity.ok(filme);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar o filme: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<Filme> filme = filmeService.getFilmeById(id);
        if (!filme.isPresent()) {
            return new ResponseEntity("Filme não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            filmeService.excluir(filme.get());
            return new ResponseEntity("Filme excluído com sucesso", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir o filme: " + e.getMessage());
        }
    }

    private Filme converter(FilmeDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Filme filme = modelMapper.map(dto, Filme.class);
        return filme;
    }
}
